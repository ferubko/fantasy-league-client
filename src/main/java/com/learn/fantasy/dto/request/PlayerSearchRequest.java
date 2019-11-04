package com.learn.fantasy.dto.request;

import java.io.Serializable;

/**
 * Created by stepanferubko
 */
public class PlayerSearchRequest implements Serializable {
    private Long teamId;
    private Long playerTypeId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getPlayerTypeId() {
        return playerTypeId;
    }

    public void setPlayerTypeId(Long playerTypeId) {
        this.playerTypeId = playerTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerSearchRequest that = (PlayerSearchRequest) o;

        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        return playerTypeId != null ? playerTypeId.equals(that.playerTypeId) : that.playerTypeId == null;

    }

    @Override
    public int hashCode() {
        int result = teamId != null ? teamId.hashCode() : 0;
        result = 31 * result + (playerTypeId != null ? playerTypeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlayerSearchRequest{" +
                "teamId=" + teamId +
                ", playerTypeId=" + playerTypeId +
                '}';
    }
}
