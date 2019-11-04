package com.learn.fantasy.dto;

/**
 * Created by stepanferubko
 */
public class Results {
    private String entry_name;

    private int rank_sort;

    private long entry;

    private int total;

    private int event_total;

    private int rank;

    private int last_rank;

    private long id;

    private String player_name;

    public String getEntry_name() {
        return entry_name;
    }

    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }

    public int getRank_sort() {
        return rank_sort;
    }

    public void setRank_sort(int rank_sort) {
        this.rank_sort = rank_sort;
    }

    public long getEntry() {
        return entry;
    }

    public void setEntry(long entry) {
        this.entry = entry;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getEvent_total() {
        return event_total;
    }

    public void setEvent_total(int event_total) {
        this.event_total = event_total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLast_rank() {
        return last_rank;
    }

    public void setLast_rank(int last_rank) {
        this.last_rank = last_rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    @Override
    public String toString() {
        return "Results{" +
                "entry_name='" + entry_name + '\'' +
                ", rank_sort=" + rank_sort +
                ", entry=" + entry +
                ", total=" + total +
                ", event_total=" + event_total +
                ", rank=" + rank +
                ", last_rank=" + last_rank +
                ", id=" + id +
                ", player_name='" + player_name + '\'' +
                '}';
    }
}
