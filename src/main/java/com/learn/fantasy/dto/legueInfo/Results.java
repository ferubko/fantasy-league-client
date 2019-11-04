package com.learn.fantasy.dto.legueInfo;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results = (Results) o;

        if (rank_sort != results.rank_sort) return false;
        if (entry != results.entry) return false;
        if (total != results.total) return false;
        if (event_total != results.event_total) return false;
        if (rank != results.rank) return false;
        if (last_rank != results.last_rank) return false;
        if (id != results.id) return false;
        if (entry_name != null ? !entry_name.equals(results.entry_name) : results.entry_name != null) return false;
        return player_name != null ? player_name.equals(results.player_name) : results.player_name == null;

    }

    @Override
    public int hashCode() {
        int result = entry_name != null ? entry_name.hashCode() : 0;
        result = 31 * result + rank_sort;
        result = 31 * result + (int) (entry ^ (entry >>> 32));
        result = 31 * result + total;
        result = 31 * result + event_total;
        result = 31 * result + rank;
        result = 31 * result + last_rank;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (player_name != null ? player_name.hashCode() : 0);
        return result;
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
