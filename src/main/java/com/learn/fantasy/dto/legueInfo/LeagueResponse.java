package com.learn.fantasy.dto.legueInfo;


/**
 * Created by stepanferubko
 */
public class LeagueResponse {
    private New_entries new_entries;
    private League league;
    private Standings standings;

    public New_entries getNew_entries() {
        return new_entries;
    }

    public void setNew_entries(New_entries new_entries) {
        this.new_entries = new_entries;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Standings getStandings() {
        return standings;
    }

    public void setStandings(Standings standings) {
        this.standings = standings;
    }

    @Override
    public String toString() {
        return "LeagueResponse{" +
                "new_entries=" + new_entries +
                ", league=" + league +
                ", standings=" + standings +
                '}';
    }
}
