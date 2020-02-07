package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.entity.Player;
import com.learn.fantasy.exception.InternalServiceInvocationException;
import com.learn.fantasy.repository.PlayerHistoryRepository;
import com.learn.fantasy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int executeSyncMissingData() throws InternalServiceInvocationException {
        LOG.info("Started execute Sync Missing Data...");
        FullInfo fullInformation = migrationService.getFullInfo();
        if (fullInformation != null) {
            List<Long> playerIds = playerRepository.findPlayerIds();
            int transfers = synchronizeTransfers(fullInformation, playerIds);
            int missedPlayers = synchronizeMissedPlayers(fullInformation, playerIds);
            return transfers + missedPlayers;
        }
        LOG.info("There is no data...");
        return 0;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int executeSyncExistingData() throws InternalServiceInvocationException {
        LOG.info("Started execute Sync Existing Data...");
        FullInfo fullInformation = migrationService.getFullInfo();
        if (fullInformation != null) {
            List<Long> playerIds = playerRepository.findPlayerIds();
            return synchronizePlayerInformation(fullInformation, playerIds);
        }
        LOG.info("There is no data...");
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int synchronizeTransfers(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException {
        LOG.info("Started synchronizing transfers...");
        try {
            List<Elements> elements = fullInformation.getElements();
            List<Long> elementIds = elements.parallelStream().map(Elements::getId).collect(Collectors.toList());
            Stream<Long> streamWithMissedPlayers = playerIds.parallelStream().filter(pl -> elementIds.stream().noneMatch(pl::equals));
            Stream<Long> streamWithTransferredPlayers = elements.parallelStream().filter(el -> el.getStatus().equals("u")).map(Elements::getId);
            List<Long> missedPlayers = Stream.concat(streamWithMissedPlayers, streamWithTransferredPlayers).collect(Collectors.toList());
            AtomicInteger deleted = new AtomicInteger(0);
            missedPlayers.forEach(elId -> {
                playerHistoryRepository.removePlayerHistoryByPlayerId(elId);
                playerRepository.deleteById(elId);
                deleted.incrementAndGet();
            });
            LOG.info("Removed players: " + deleted.get());
            return deleted.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in get statistic");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int synchronizeMissedPlayers(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException {
        LOG.info("Started synchronizing missed players...");
        try {
            List<Elements> elements = fullInformation.getElements();
            List<Player> players = elements.parallelStream()
                    .filter(el -> playerIds.parallelStream().noneMatch(pl -> el.getId() == pl))
                    .map(p -> migrationService.convertPlayer(p))
                    .collect(Collectors.toList());
            players.parallelStream().forEach(player -> {
                LOG.info("Player: " + player.toString());
                playerRepository.save(player);
                migrationService.savePlayerHistory(player);
            });
            LOG.info("Added players: " + players.size());
            return players.size();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceInvocationException("501", "Error in get statistic");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int synchronizePlayerInformation(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException {
        LOG.info("Started synchronize player info...");
        try {
            List<Elements> elements = fullInformation.getElements();
            AtomicInteger added = new AtomicInteger(0);
            elements.parallelStream()
                    .filter(el -> playerIds.stream().anyMatch(pl -> pl == el.getId()))
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
            throw new InternalServiceInvocationException("501", "Error in get statistic");
        }
    }
}
