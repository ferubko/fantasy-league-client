package com.learn.fantasy.service;

import com.learn.fantasy.entity.Player;

public interface SynchronizeService {
    int checkIfPlayersExist();

    int synchronisePlayersInformation();

    void synchronisePlayerHistory(Player player);
}
