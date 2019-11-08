package com.learn.fantasy.vo;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by stepanferubko
 */
public class PlayerVO implements Serializable {
    private Long id;
    private Long code;
    private String firstName;
    private String secondName;
    private String news;
    private String photo;
    private double averagePoints;
    private int goalsScored;
    private int assists;
    private int cleanSheets;
    private int penaltiesSaved;
    private double influence;
    private double creativity;
    private double threat;
    private Integer totalPoints;
    private Long elementType;
    private Boolean isCaptain;
    private Boolean isViceCaptain;
    private TeamVO team;
    private PlayerTypeVO playerType;
    private Set<PlayerHistoryVO> playerHistory;
//    private LeagueMemberVO leagueMember;

    public PlayerVO(Long id) {
        this.id = id;
    }

    public PlayerVO() {
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

    public double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public void setPenaltiesSaved(int penaltiesSaved) {
        this.penaltiesSaved = penaltiesSaved;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
    }

    public double getCreativity() {
        return creativity;
    }

    public void setCreativity(double creativity) {
        this.creativity = creativity;
    }

    public double getThreat() {
        return threat;
    }

    public void setThreat(double threat) {
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

    public TeamVO getTeam() {
        return team;
    }

    public void setTeam(TeamVO team) {
        this.team = team;
    }

    public PlayerTypeVO getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerTypeVO playerType) {
        this.playerType = playerType;
    }

    public Set<PlayerHistoryVO> getPlayerHistory() {
        return playerHistory;
    }

    public void setPlayerHistory(Set<PlayerHistoryVO> playerHistory) {
        this.playerHistory = playerHistory;
    }

//    public LeagueMemberVO getLeagueMember() {
//        return leagueMember;
//    }
//
//    public void setLeagueMember(LeagueMemberVO leagueMember) {
//        this.leagueMember = leagueMember;
//    }

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
//                ", leagueMember=" + leagueMember +
                '}';
    }
}
