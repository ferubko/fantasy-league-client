package com.learn.fantasy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by stepanferubko
 */
@Entity
@Table
@JsonIgnoreProperties(value = {"playerHistory"})
public class Player implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "code")
    private Long code;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "news")
    private String news;
    @Column(name = "totalPoints")
    private Integer totalPoints;
    @Column(name = "elementType")
    private Long elementType;
    @Column
    private Boolean isCaptain;
    @Column
    private Boolean isViceCaptain;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
//    @JsonIgnore
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_type_id")
//    @JsonIgnore
    private PlayerType playerType;
    //    @JsonManagedReference
    @OneToMany(mappedBy = "player")//, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = "player")
//    @JsonIgnore//Properties(value = "player", allowSetters = true)
//    @JsonProperty(value = "playerHistories")
    private Set<PlayerHistory> playerHistory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "leagueMember_id")
    private LeagueMember leagueMember;

    public Player(Long id) {
        this.id = id;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getElementType() {
        return elementType;
    }

    public void setElementType(Long elementType) {
        this.elementType = elementType;
    }

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public Boolean getViceCaptain() {
        return isViceCaptain;
    }

    public void setViceCaptain(Boolean viceCaptain) {
        isViceCaptain = viceCaptain;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Set<PlayerHistory> getPlayerHistory() {
        return playerHistory;
    }

    public void setPlayerHistory(Set<PlayerHistory> playerHistory) {
        this.playerHistory = playerHistory;
    }

    public LeagueMember getLeagueMember() {
        return leagueMember;
    }

    public void setLeagueMember(LeagueMember leagueMember) {
        this.leagueMember = leagueMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != null ? !id.equals(player.id) : player.id != null) return false;
        if (code != null ? !code.equals(player.code) : player.code != null) return false;
        if (firstName != null ? !firstName.equals(player.firstName) : player.firstName != null) return false;
        if (secondName != null ? !secondName.equals(player.secondName) : player.secondName != null) return false;
        if (news != null ? !news.equals(player.news) : player.news != null) return false;
        if (totalPoints != null ? !totalPoints.equals(player.totalPoints) : player.totalPoints != null) return false;
        if (elementType != null ? !elementType.equals(player.elementType) : player.elementType != null) return false;
        if (isCaptain != null ? !isCaptain.equals(player.isCaptain) : player.isCaptain != null) return false;
        if (isViceCaptain != null ? !isViceCaptain.equals(player.isViceCaptain) : player.isViceCaptain != null)
            return false;
        if (team != null ? !team.equals(player.team) : player.team != null) return false;
        if (playerType != null ? !playerType.equals(player.playerType) : player.playerType != null) return false;
        if (playerHistory != null ? !playerHistory.equals(player.playerHistory) : player.playerHistory != null)
            return false;
        return leagueMember != null ? leagueMember.equals(player.leagueMember) : player.leagueMember == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (news != null ? news.hashCode() : 0);
        result = 31 * result + (totalPoints != null ? totalPoints.hashCode() : 0);
        result = 31 * result + (elementType != null ? elementType.hashCode() : 0);
        result = 31 * result + (isCaptain != null ? isCaptain.hashCode() : 0);
        result = 31 * result + (isViceCaptain != null ? isViceCaptain.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (playerType != null ? playerType.hashCode() : 0);
        result = 31 * result + (playerHistory != null ? playerHistory.hashCode() : 0);
        result = 31 * result + (leagueMember != null ? leagueMember.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlayerVO{" +
                "id=" + id +
                ", code=" + code +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", news='" + news + '\'' +
                ", totalPoints=" + totalPoints +
                ", elementType=" + elementType +
                ", isCaptain=" + isCaptain +
                ", isViceCaptain=" + isViceCaptain +
                ", team=" + team +
                ", playerType=" + playerType +
                ", playerHistory=" + playerHistory +
                ", leagueMember=" + leagueMember +
                '}';
    }
}
