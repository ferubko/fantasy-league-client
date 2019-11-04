package com.learn.fantasy.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stepanferubko
 */
public class PlayerHistoryVO implements Serializable {
    private Long id;
    private Long element;
    private Long opponentTeam;
    private Integer totalPoints;
    private Date kickoffTime;

    public PlayerHistoryVO(Long id) {
        this.id = id;
    }

    public PlayerHistoryVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getElement() {
        return element;
    }

    public void setElement(Long element) {
        this.element = element;
    }

    public Long getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(Long opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Date getKickoffTime() {
        return kickoffTime;
    }

    public void setKickoffTime(Date kickoffTime) {
        this.kickoffTime = kickoffTime;
    }
}
