package com.learn.fantasy.vo;

import com.learn.fantasy.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TransferSynchResultVO {
    private List<Long> idNewPlayers = new ArrayList<>();
    private List<Long> idOldPlayers = new ArrayList<>();
    private List<Player> addedPlayers = new ArrayList<>();
    private int addedPlayersCount = 0;
    private int removedPlayersCount = 0;

    public List<Long> getIdNewPlayers() {
        return idNewPlayers;
    }

    public void setIdNewPlayers(List<Long> idNewPlayers) {
        this.idNewPlayers = idNewPlayers;
    }

    public List<Long> getIdOldPlayers() {
        return idOldPlayers;
    }

    public void setIdOldPlayers(List<Long> idOldPlayers) {
        this.idOldPlayers = idOldPlayers;
    }

    public List<Player> getAddedPlayers() {
        return addedPlayers;
    }

    public void setAddedPlayers(List<Player> addedPlayers) {
        this.addedPlayers = addedPlayers;
    }

    public int getAddedPlayersCount() {
        return addedPlayersCount;
    }

    public void setAddedPlayersCount(int addedPlayersCount) {
        this.addedPlayersCount = addedPlayersCount;
    }

    public int getRemovedPlayersCount() {
        return removedPlayersCount;
    }

    public void setRemovedPlayersCount(int removedPlayersCount) {
        this.removedPlayersCount = removedPlayersCount;
    }
}
