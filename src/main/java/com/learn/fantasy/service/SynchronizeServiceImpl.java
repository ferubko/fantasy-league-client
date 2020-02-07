package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.entity.Player;
import com.learn.fantasy.exception.InternalServiceInvocationException;
import com.learn.fantasy.repository.PlayerHistoryRepository;
import com.learn.fantasy.repository.PlayerRepository;
import com.learn.fantasy.vo.TransferSynchResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class SynchronizeServiceImpl implements SynchronizeService {
    private final static Logger LOG = Logger.getLogger(SynchronizeServiceImpl.class.getName());
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerHistoryRepository playerHistoryRepository;
    @Autowired
    private MigrationService migrationService;

    @Override
    public TransferSynchResultVO collectActualPlayerInformation() throws InternalServiceInvocationException {
        LOG.info("Started collect actual player Information...");
        TransferSynchResultVO transferSynchResultVO = new TransferSynchResultVO();
        try {
            FullInfo fullInformation = migrationService.getFullInfo();
            if (fullInformation != null) {
                List<Long> playerIds = playerRepository.findPlayerIds();
                List<Elements> elements = fullInformation.getElements();
                List<Long> oldPlayers = playerIds.parallelStream()
                        .filter(pl -> elements.parallelStream().anyMatch(el -> pl == el.getId() && el.getStatus().equals("u")))
                        .collect(Collectors.toList());
                transferSynchResultVO.setIdOldPlayers(oldPlayers);
                transferSynchResultVO.setRemovedPlayersCount(oldPlayers.size());
                List<Player> newPlayers = elements.parallelStream()
                        .filter(el -> playerIds.parallelStream().noneMatch(pl -> pl == el.getId()) && !el.getStatus().equals("u"))
                        .map(p -> migrationService.convertPlayer(p))
                        .collect(Collectors.toList());
                transferSynchResultVO.setAddedPlayers(newPlayers);
                transferSynchResultVO.setAddedPlayersCount(newPlayers.size());
            }
            return transferSynchResultVO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in collect actual player Information");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int executeSyncMissingData() {
        LOG.info("Started execute Sync Missing Data...");
        try {
            TransferSynchResultVO transferSynchResultVO = collectActualPlayerInformation();
            int transfers = synchronizeTransfers(transferSynchResultVO);
            int missedPlayers = synchronizeMissedPlayers(transferSynchResultVO);
            return transfers + missedPlayers;
        } catch (InternalServiceInvocationException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int executeSyncExistingData() {
        LOG.info("Started execute Sync Existing Data...");
        try {
            FullInfo fullInformation = migrationService.getFullInfo();
            if (fullInformation != null) {
                List<Long> playerIds = playerRepository.findPlayerIds();
                return synchronizePlayerInformation(fullInformation, playerIds);
            }
        } catch (InternalServiceInvocationException e) {
            e.printStackTrace();
            return 0;
        }
        LOG.info("There is no data...");
        return 0;
    }

    @Override
    public int synchronizeTransfers(TransferSynchResultVO transferSynchResultVO) throws InternalServiceInvocationException {
        LOG.info("Started synchronizing transfers...");
        try {
            List<Long> idOldPlayers = transferSynchResultVO.getIdOldPlayers();
            int removedPlayersCount = transferSynchResultVO.getRemovedPlayersCount();
            idOldPlayers.forEach(elId -> {
                playerHistoryRepository.removePlayerHistoryByPlayerId(elId);
                playerRepository.deleteById(elId);
            });
            LOG.info("Removed players: " + removedPlayersCount);
            return removedPlayersCount;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in synchronize Transfers");
        }
    }

    @Override
    public int synchronizeMissedPlayers(TransferSynchResultVO transferSynchResultVO) throws InternalServiceInvocationException {
        LOG.info("Started synchronizing missed players...");
        try {
            List<Player> players = transferSynchResultVO.getAddedPlayers();
            players.parallelStream().forEach(player -> {
                LOG.info("Player: " + player.toString());
                playerRepository.save(player);
                migrationService.savePlayerHistory(player);
            });
            LOG.info("Added players: " + players.size());
            return players.size();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in synchronize Missed Players");
        }
    }

    @Override
    public int synchronizePlayerInformation(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException {
        LOG.info("Started synchronize player info...");
        try {
            List<Elements> elements = fullInformation.getElements();
            AtomicInteger added = new AtomicInteger(0);
            elements.parallelStream()
                    .filter(el -> playerIds.parallelStream().anyMatch(pl -> pl == el.getId()))
                    .map(p -> migrationService.convertPlayer(p))
                    .forEach(pl -> {
                        LOG.info("Player: " + pl.toString());
                        playerRepository.save(pl);
                        migrationService.savePlayerHistory(pl);
                        added.incrementAndGet();
                    });
            LOG.info("Edit players information: " + added.get());
            return added.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in synchronize player Information");
        }
    }
}
