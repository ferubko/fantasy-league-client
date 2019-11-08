package com.learn.fantasy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
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
    @Column(name = "photo")
    private String photo;
    @Column(name = "averagePoints")
    private Double averagePoints;
    @Column(name = "goalsScored")
    private Integer goalsScored;
    @Column(name = "assists")
    private Integer assists;
    @Column(name = "cleanSheets")
    private Integer cleanSheets;
    @Column(name = "penaltiesSaved")
    private Integer penaltiesSaved;
    @Column(name = "influence")
    private Double influence;
    @Column(name = "creativity")
    private Double creativity;
    @Column(name = "threat")
    private Double threat;
    @Column(name = "totalPoints")
    private Integer totalPoints;
    @Column(name = "elementType")
    private Long elementType;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(Double averagePoints) {
        this.averagePoints = averagePoints;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(Integer cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public Integer getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public void setPenaltiesSaved(Integer penaltiesSaved) {
        this.penaltiesSaved = penaltiesSaved;
    }

    public Double getInfluence() {
        return influence;
    }

    public void setInfluence(Double influence) {
        this.influence = influence;
    }

    public Double getCreativity() {
        return creativity;
    }

    public void setCreativity(Double creativity) {
        this.creativity = creativity;
    }

    public Double getThreat() {
        return threat;
    }

    public void setThreat(Double threat) {
        this.threat = threat;
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
        return Double.compare(player.averagePoints, averagePoints) == 0 &&
                goalsScored == player.goalsScored &&
                assists == player.assists &&
                cleanSheets == player.cleanSheets &&
                penaltiesSaved == player.penaltiesSaved &&
                Double.compare(player.influence, influence) == 0 &&
                Double.compare(player.creativity, creativity) == 0 &&
                Double.compare(player.threat, threat) == 0 &&
                Objects.equals(id, player.id) &&
                Objects.equals(code, player.code) &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(secondName, player.secondName) &&
                Objects.equals(news, player.news) &&
                Objects.equals(photo, player.photo) &&
                Objects.equals(totalPoints, player.totalPoints) &&
                Objects.equals(elementType, player.elementType) &&
                Objects.equals(team, player.team) &&
                Objects.equals(playerType, player.playerType) &&
                Objects.equals(playerHistory, player.playerHistory) &&
                Objects.equals(leagueMember, player.leagueMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, firstName, secondName, news, photo, averagePoints, goalsScored, assists, cleanSheets, penaltiesSaved, influence, creativity, threat, totalPoints, elementType, team, playerType, playerHistory, leagueMember);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", code=" + code +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", news='" + news + '\'' +
                ", photo='" + photo + '\'' +
                ", averagePoints=" + averagePoints +
                ", goalsScored=" + goalsScored +
                ", assists=" + assists +
                ", cleanSheets=" + cleanSheets +
                ", penaltiesSaved=" + penaltiesSaved +
                ", influence=" + influence +
                ", creativity=" + creativity +
                ", threat=" + threat +
                ", totalPoints=" + totalPoints +
                ", elementType=" + elementType +
                ", team=" + team +
                ", playerType=" + playerType +
                ", playerHistory=" + playerHistory +
                ", leagueMember=" + leagueMember +
                '}';
    }
}
