package com.learn.fantasy.dto.fullinfo;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class FullInfo {
    private List<Teams> teams;
    private long total_players;
    private List<Elements> elements;

    private List<Element_stats> element_stats;
    private List<Element_types> element_types;

    private List<Events> events;
    private Game_settings game_settings;

    private List<Phases> phases;

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> teams) {
        this.teams = teams;
    }

    public long getTotal_players() {
        return total_players;
    }

    public void setTotal_players(long total_players) {
        this.total_players = total_players;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

    public List<Element_stats> getElement_stats() {
        return element_stats;
    }

    public void setElement_stats(List<Element_stats> element_stats) {
        this.element_stats = element_stats;
    }

    public List<Element_types> getElement_types() {
        return element_types;
    }

    public void setElement_types(List<Element_types> element_types) {
        this.element_types = element_types;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public Game_settings getGame_settings() {
        return game_settings;
    }

    public void setGame_settings(Game_settings game_settings) {
        this.game_settings = game_settings;
    }

    public List<Phases> getPhases() {
        return phases;
    }

    public void setPhases(List<Phases> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        return "FullInfo{" +
                "teams=" + teams +
                ", total_players=" + total_players +
                ", elements=" + elements +
                ", element_stats=" + element_stats +
                ", element_types=" + element_types +
                ", events=" + events +
                ", game_settings=" + game_settings +
                ", phases=" + phases +
                '}';
    }
}
