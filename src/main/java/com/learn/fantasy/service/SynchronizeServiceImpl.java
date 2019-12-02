package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.entity.Player;
import com.learn.fantasy.repository.PlayerHistoryRepository;
import com.learn.fantasy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    public int checkIfPlayersExist() {
        LOG.info("Started checking Player if exist...");
        FullInfo fullInformation = migrationService.getFullInfo();
        if (fullInformation != null) {
            try {
                List<Elements> elements = fullInformation.getElements();
                List<Long> elementIds = elements.stream().map(Elements::getId).collect(Collectors.toList());
                elementIds.removeIf(next -> next == 192);
                List<Long> missingIds = collectMissingPlayers(elementIds);
                LOG.info("missingIds: " + missingIds.toString());
                LOG.info("Element list is: " + elementIds.size());
                AtomicInteger deleted = new AtomicInteger(0);
                AtomicInteger added = new AtomicInteger(0);
                missingIds.forEach(elId -> {
                    boolean ifExist = playerRepository.existsById(elId);
                    LOG.info("id: "+elId+" exist: "+ifExist);
                    if (ifExist) {
                        playerHistoryRepository.removePlayerHistoryByPlayerId(elId);
                        playerRepository.deleteById(elId);
                        deleted.incrementAndGet();
                    } else {
                        addNewHistoryToPlayer(elements, added, elId);
                    }
                });

                LOG.info("Removed: " + deleted.get() + " " + "Added: " + added.get());
                return deleted.addAndGet(added.get());
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private List<Long> collectMissingPlayers(List<Long> elementIds) {
        List<Long> playerIds = playerRepository.findPlayerIds();

        return Stream.concat(
                playerIds.stream().filter(c -> !elementIds.contains(c)),
                elementIds.stream().filter(c -> !playerIds.contains(c))
        ).collect(Collectors.toList());
    }

    private void addNewHistoryToPlayer(List<Elements> elements, AtomicInteger added, Long elId) {
        Optional<Player> playerOptional = elements.stream()
                .filter(el -> el.getId() == elId)
                .map(p -> migrationService.convertPlayer(p))
                .findFirst();
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            LOG.info("player: " + player.toString());
            playerRepository.save(player);
            migrationService.savePlayerHistory(player);
            added.incrementAndGet();
        }
    }

    @Override
    public int synchronisePlayersInformation() {
        return 0;
    }

    @Override
    public void synchronisePlayerHistory(Player player) {
    }
}
