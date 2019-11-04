package com.learn.fantasy.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by stepanferubko
 */
public class LeagueMemberVO implements Serializable {
    private Long id;
    private Integer eventTotal;
    private String playerName;
    private Integer rank;
    private Integer lastRank;
    private Integer rankSort;
    private Integer total;
    private Integer currentEvent;
    private Long entry;
    private String entryName;
    //    private LeagueVO league;
    private List<PlayerVO> startingLineup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEventTotal() {
        return eventTotal;
    }

    public void setEventTotal(Integer eventTotal) {
        this.eventTotal = eventTotal;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getLastRank() {
        return lastRank;
    }

    public void setLastRank(Integer lastRank) {
        this.lastRank = lastRank;
    }

    public Integer getRankSort() {
        return rankSort;
    }

    public void setRankSort(Integer rankSort) {
        this.rankSort = rankSort;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Integer currentEvent) {
        this.currentEvent = currentEvent;
    }

    public Long getEntry() {
        return entry;
    }

    public void setEntry(Long entry) {
        this.entry = entry;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

//    public LeagueVO getLeague() {
//        return league;
//    }
//
//    public void setLeague(LeagueVO league) {
//        this.league = league;
//    }

    public List<PlayerVO> getStartingLineup() {
        return startingLineup;
    }

    public void setStartingLineup(List<PlayerVO> startingLineup) {
        this.startingLineup = startingLineup;
    }

}
