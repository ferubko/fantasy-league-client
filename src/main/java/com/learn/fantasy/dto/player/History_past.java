package com.learn.fantasy.dto.player;

/**
 * Created by stepanferubko
 */
public class History_past {
    private int goals_scored;
    private double end_cost;
    private int bps;
    private String season_name;
    private int minutes;
    private int own_goals;
    private int bonus;
    private int total_points;
    private int clean_sheets;
    private int goals_conceded;
    private int penalties_missed;
    private int yellow_cards;
    private int red_cards;
    private double influence;
    private int saves;
    private int assists;
    private double threat;
    private double creativity;
    private double ict_index;
    private long element_code;
    private double start_cost;
    private int penalties_saved;

    public int getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(int goals_scored) {
        this.goals_scored = goals_scored;
    }

    public double getEnd_cost() {
        return end_cost;
    }

    public void setEnd_cost(double end_cost) {
        this.end_cost = end_cost;
    }

    public int getBps() {
        return bps;
    }

    public void setBps(int bps) {
        this.bps = bps;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
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

    public int getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(int red_cards) {
        this.red_cards = red_cards;
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

    public double getThreat() {
        return threat;
    }

    public void setThreat(double threat) {
        this.threat = threat;
    }

    public double getCreativity() {
        return creativity;
    }

    public void setCreativity(double creativity) {
        this.creativity = creativity;
    }

    public double getIct_index() {
        return ict_index;
    }

    public void setIct_index(double ict_index) {
        this.ict_index = ict_index;
    }

    public long getElement_code() {
        return element_code;
    }

    public void setElement_code(long element_code) {
        this.element_code = element_code;
    }

    public double getStart_cost() {
        return start_cost;
    }

    public void setStart_cost(double start_cost) {
        this.start_cost = start_cost;
    }

    public int getPenalties_saved() {
        return penalties_saved;
    }

    public void setPenalties_saved(int penalties_saved) {
        this.penalties_saved = penalties_saved;
    }

    @Override
    public String toString() {
        return "History_past{" +
                "goals_scored=" + goals_scored +
                ", end_cost=" + end_cost +
                ", bps=" + bps +
                ", season_name='" + season_name + '\'' +
                ", minutes=" + minutes +
                ", own_goals=" + own_goals +
                ", bonus=" + bonus +
                ", total_points=" + total_points +
                ", clean_sheets=" + clean_sheets +
                ", goals_conceded=" + goals_conceded +
                ", penalties_missed=" + penalties_missed +
                ", yellow_cards=" + yellow_cards +
                ", red_cards=" + red_cards +
                ", influence=" + influence +
                ", saves=" + saves +
                ", assists=" + assists +
                ", threat=" + threat +
                ", creativity=" + creativity +
                ", ict_index=" + ict_index +
                ", element_code=" + element_code +
                ", start_cost=" + start_cost +
                ", penalties_saved=" + penalties_saved +
                '}';
    }
}
