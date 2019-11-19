package com.learn.fantasy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by stepanferubko
 */
@Entity
@Table
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "element")
    private Long element;
    @Column(name = "opponentTeam")
    private Long opponentTeam;
    @Column(name = "totalPoints")
    private Integer totalPoints;
    @Column(name = "kickoffTime")
    private Date kickoffTime;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore//Properties(value = "playerHistory", allowSetters = true)
    private Player player;

    public PlayerHistory(Long id) {
        this.id = id;
    }

    public PlayerHistory() {
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerHistory that = (PlayerHistory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (element != null ? !element.equals(that.element) : that.element != null) return false;
        if (opponentTeam != null ? !opponentTeam.equals(that.opponentTeam) : that.opponentTeam != null) return false;
        if (totalPoints != null ? !totalPoints.equals(that.totalPoints) : that.totalPoints != null) return false;
        return kickoffTime != null ? kickoffTime.equals(that.kickoffTime) : that.kickoffTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (element != null ? element.hashCode() : 0);
        result = 31 * result + (opponentTeam != null ? opponentTeam.hashCode() : 0);
        result = 31 * result + (totalPoints != null ? totalPoints.hashCode() : 0);
        result = 31 * result + (kickoffTime != null ? kickoffTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlayerHistory{" +
                "id=" + id +
                ", element=" + element +
                ", opponentTeam=" + opponentTeam +
                ", totalPoints=" + totalPoints +
                ", kickoffTime=" + kickoffTime +
                '}';
    }
}
