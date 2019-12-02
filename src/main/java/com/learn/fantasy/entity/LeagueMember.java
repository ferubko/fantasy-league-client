package com.learn.fantasy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by stepanferubko
 */
@Entity
@Table
public class LeagueMember implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "eventTotal")
    private Integer eventTotal;
    @Column(name = "playerName")
    private String playerName;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "lastRank")
    private Integer lastRank;
    @Column(name = "rankSort")
    private Integer rankSort;
    @Column(name = "total")
    private Integer total;
    @Column(name = "entry")
    private Long entry;
    @Column(name = "entryName")
    private String entryName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "league_id")
    private League league;
//    @OneToMany(mappedBy = "leagueMember", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Player> startingLineup;

    public LeagueMember(Long id) {
        this.id = id;
    }

    public LeagueMember() {
    }

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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

//    public List<Player> getStartingLineup() {
//        return startingLineup;
//    }
//
//    public void setStartingLineup(List<Player> startingLineup) {
//        this.startingLineup = startingLineup;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueMember that = (LeagueMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eventTotal != null ? !eventTotal.equals(that.eventTotal) : that.eventTotal != null) return false;
        if (playerName != null ? !playerName.equals(that.playerName) : that.playerName != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (lastRank != null ? !lastRank.equals(that.lastRank) : that.lastRank != null) return false;
        if (rankSort != null ? !rankSort.equals(that.rankSort) : that.rankSort != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (entry != null ? !entry.equals(that.entry) : that.entry != null) return false;
        if (entryName != null ? !entryName.equals(that.entryName) : that.entryName != null) return false;
        return league != null ? league.equals(that.league) : that.league == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventTotal != null ? eventTotal.hashCode() : 0);
        result = 31 * result + (playerName != null ? playerName.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (lastRank != null ? lastRank.hashCode() : 0);
        result = 31 * result + (rankSort != null ? rankSort.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        result = 31 * result + (entryName != null ? entryName.hashCode() : 0);
        result = 31 * result + (league != null ? league.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeagueMemberVO{" +
                "id=" + id +
                ", eventTotal=" + eventTotal +
                ", playerName='" + playerName + '\'' +
                ", rank=" + rank +
                ", lastRank=" + lastRank +
                ", rankSort=" + rankSort +
                ", total=" + total +
                ", entry=" + entry +
                ", entryName='" + entryName + '\'' +
                ", league=" + league +
                '}';
    }
}
