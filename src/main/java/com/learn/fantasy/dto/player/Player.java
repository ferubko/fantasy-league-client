package com.learn.fantasy.dto.player;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Player {
    private List<History_past> history_past;

    private List<History> history;

    private List<Fixtures> fixtures;

    public List<History_past> getHistory_past() {
        return history_past;
    }

    public void setHistory_past(List<History_past> history_past) {
        this.history_past = history_past;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public List<Fixtures> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixtures> fixtures) {
        this.fixtures = fixtures;
    }

    @Override
    public String toString() {
        return "Player{" +
                "history_past=" + history_past +
                ", history=" + history +
                ", fixtures=" + fixtures +
                '}';
    }
}
