package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.entity.Player;
import com.learn.fantasy.repository.PlayerHistoryRepository;
import com.learn.fantasy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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
    public int checkIfPlayersExist() {
        LOG.info("Started checking Player if exist...");
        FullInfo fullInformation = migrationService.getFullInfo();
        if (fullInformation != null) {
            try {
                List<Elements> elements = fullInformation.getElements();
                List<Long> elementIds = elements.stream().map(Elements::getId).collect(Collectors.toList());
                elementIds.removeIf(next -> next == 192);

                LOG.info("Element list is: " + elementIds.size());
                AtomicInteger result = new AtomicInteger(0);
                elementIds.forEach(elId -> {
                    boolean ifExist = playerRepository.existsById(elId);
                    LOG.info("ifExist: " + ifExist);
                    if (!ifExist) {
                        playerHistoryRepository.removePlayerHistoryByPlayerId(elId);
                        playerRepository.deleteById(elId);
                        result.incrementAndGet();
                    }
                });
                LOG.info("Removing was " +  result.get());
                return result.get();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int synchronisePlayersInformation() {
        return 0;
    }

    @Override
    public void synchronisePlayerHistory(Player player) {
    }
}
