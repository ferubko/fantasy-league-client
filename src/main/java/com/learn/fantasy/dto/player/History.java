package com.learn.fantasy.dto.player;

import java.util.Date;

/**
 * Created by stepanferubko
 */
public class History {
    private int transfers_balance;
    private long opponent_team;
    private int own_goals;
    private int bonus;
    private int total_points;
    private int clean_sheets;
    private int goals_conceded;
    private Date kickoff_time;
    private int red_cards;
    private int team_a_score;
    private double influence;
    private int saves;
    private int assists;
    private int transfers_in;
    private double creativity;
    private int value;
    private long selected;
    private long element;
    private int goals_scored;
    private boolean was_home;
    private int bps;
    private int minutes;
    private int penalties_missed;
    private int yellow_cards;
    private long fixture;
    private int transfers_out;
    private int round;
    private double threat;
    private double ict_index;
    private int team_h_score;
    private int penalties_saved;

    public int getTransfers_balance() {
        return transfers_balance;
    }

    public void setTransfers_balance(int transfers_balance) {
        this.transfers_balance = transfers_balance;
    }

    public long getOpponent_team() {
        return opponent_team;
    }

    public void setOpponent_team(long opponent_team) {
        this.opponent_team = opponent_team;
    }

    public int getOwn_goals() {
        return own_goals;
    }

    public void setOwn_goals(int own_goals) {
        this.own_goals = own_goals;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public int getClean_sheets() {
        return clean_sheets;
    }

    public void setClean_sheets(int clean_sheets) {
        this.clean_sheets = clean_sheets;
    }

    public int getGoals_conceded() {
        return goals_conceded;
    }

    public void setGoals_conceded(int goals_conceded) {
        this.goals_conceded = goals_conceded;
    }

    public Date getKickoff_time() {
        return kickoff_time;
    }

    public void setKickoff_time(Date kickoff_time) {
        this.kickoff_time = kickoff_time;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(int red_cards) {
        this.red_cards = red_cards;
    }

    public int getTeam_a_score() {
        return team_a_score;
    }

    public void setTeam_a_score(int team_a_score) {
        this.team_a_score = team_a_score;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTransfers_in() {
        return transfers_in;
    }

    public void setTransfers_in(int transfers_in) {
        this.transfers_in = transfers_in;
    }

    public double getCreativity() {
        return creativity;
    }

    public void setCreativity(double creativity) {
        this.creativity = creativity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getSelected() {
        return selected;
    }

    public void setSelected(long selected) {
        this.selected = selected;
    }

    public long getElement() {
        return element;
    }

    public void setElement(long element) {
        this.element = element;
    }

    public int getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(int goals_scored) {
        this.goals_scored = goals_scored;
    }

    public boolean isWas_home() {
        return was_home;
    }

    public void setWas_home(boolean was_home) {
        this.was_home = was_home;
    }

    public int getBps() {
        return bps;
    }

    public void setBps(int bps) {
        this.bps = bps;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getPenalties_missed() {
        return penalties_missed;
    }

    public void setPenalties_missed(int penalties_missed) {
        this.penalties_missed = penalties_missed;
    }

    public int getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(int yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public long getFixture() {
        return fixture;
    }

    public void setFixture(long fixture) {
        this.fixture = fixture;
    }

    public int getTransfers_out() {
        return transfers_out;
    }

    public void setTransfers_out(int transfers_out) {
        this.transfers_out = transfers_out;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public double getThreat() {
        return threat;
    }

    public void setThreat(double threat) {
        this.threat = threat;
    }

    public double getIct_index() {
        return ict_index;
    }

    public void setIct_index(double ict_index) {
        this.ict_index = ict_index;
    }

    public int getTeam_h_score() {
        return team_h_score;
    }

    public void setTeam_h_score(int team_h_score) {
        this.team_h_score = team_h_score;
    }

    public int getPenalties_saved() {
        return penalties_saved;
    }

    public void setPenalties_saved(int penalties_saved) {
        this.penalties_saved = penalties_saved;
    }

    @Override
    public String toString() {
        return "History{" +
                "transfers_balance=" + transfers_balance +
                ", opponent_team=" + opponent_team +
                ", own_goals=" + own_goals +
                ", bonus=" + bonus +
                ", total_points=" + total_points +
                ", clean_sheets=" + clean_sheets +
                ", goals_conceded=" + goals_conceded +
                ", kickoff_time=" + kickoff_time +
                ", red_cards=" + red_cards +
                ", team_a_score=" + team_a_score +
                ", influence=" + influence +
                ", saves=" + saves +
                ", assists=" + assists +
                ", transfers_in=" + transfers_in +
                ", creativity=" + creativity +
                ", value=" + value +
                ", selected=" + selected +
                ", element=" + element +
                ", goals_scored=" + goals_scored +
                ", was_home=" + was_home +
                ", bps=" + bps +
                ", minutes=" + minutes +
                ", penalties_missed=" + penalties_missed +
                ", yellow_cards=" + yellow_cards +
                ", fixture=" + fixture +
                ", transfers_out=" + transfers_out +
                ", round=" + round +
                ", threat=" + threat +
                ", ict_index=" + ict_index +
                ", team_h_score=" + team_h_score +
                ", penalties_saved=" + penalties_saved +
                '}';
    }
}
