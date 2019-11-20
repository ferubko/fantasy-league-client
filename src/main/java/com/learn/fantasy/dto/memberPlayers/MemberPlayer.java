package com.learn.fantasy.dto.memberPlayers;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class MemberPlayer {
    private Entry_history entry_history;
    private List<Automatic_subs> automatic_subs;
    private List<Picks> picks;
    private String active_chip;

    public Entry_history getEntry_history() {
        return entry_history;
    }

    public void setEntry_history(Entry_history entry_history) {
        this.entry_history = entry_history;
    }

    public List<Automatic_subs> getAutomatic_subs() {
        return automatic_subs;
    }

    public void setAutomatic_subs(List<Automatic_subs> automatic_subs) {
        this.automatic_subs = automatic_subs;
    }

    public List<Picks> getPicks() {
        return picks;
    }

    public void setPicks(List<Picks> picks) {
        this.picks = picks;
    }

    public String getActive_chip() {
        return active_chip;
    }

    public void setActive_chip(String active_chip) {
        this.active_chip = active_chip;
    }

    @Override
    public String toString() {
        return "MemberPlayer{" +
                "entry_history=" + entry_history +
                ", automatic_subs=" + automatic_subs +
                ", picks=" + picks +
                ", active_chip='" + active_chip + '\'' +
                '}';
    }
}
