package com.learn.fantasy.dto.fullinfo;

/**
 * Created by stepanferubko
 */
public class Teams {
    private int strength_defence_away;

    private long code;

    private int strength;

    private boolean unavailable;

    private int strength_overall_away;

    private int draw;

    private String team_division;

    private int played;

    private int strength_attack_away;

    private int points;

    private int loss;

    private int strength_defence_home;

    private String form;

    private int strength_attack_home;

    private int strength_overall_home;

    private String name;

    private String short_name;

    private long id;

    private int position;

    private int win;

    public int getStrength_defence_away() {
        return strength_defence_away;
    }

    public void setStrength_defence_away(int strength_defence_away) {
        this.strength_defence_away = strength_defence_away;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isUnavailable() {
        return unavailable;
    }

    public void setUnavailable(boolean unavailable) {
        this.unavailable = unavailable;
    }

    public int getStrength_overall_away() {
        return strength_overall_away;
    }

    public void setStrength_overall_away(int strength_overall_away) {
        this.strength_overall_away = strength_overall_away;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getTeam_division() {
        return team_division;
    }

    public void setTeam_division(String team_division) {
        this.team_division = team_division;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getStrength_attack_away() {
        return strength_attack_away;
    }

    public void setStrength_attack_away(int strength_attack_away) {
        this.strength_attack_away = strength_attack_away;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getStrength_defence_home() {
        return strength_defence_home;
    }

    public void setStrength_defence_home(int strength_defence_home) {
        this.strength_defence_home = strength_defence_home;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getStrength_attack_home() {
        return strength_attack_home;
    }

    public void setStrength_attack_home(int strength_attack_home) {
        this.strength_attack_home = strength_attack_home;
    }

    public int getStrength_overall_home() {
        return strength_overall_home;
    }

    public void setStrength_overall_home(int strength_overall_home) {
        this.strength_overall_home = strength_overall_home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    @Override
    public String toString() {
        return "ClassPojo [strength_defence_away = " + strength_defence_away + ", code = " + code + ", strength = " + strength + ", unavailable = " + unavailable + ", strength_overall_away = " + strength_overall_away + ", draw = " + draw + ", team_division = " + team_division + ", played = " + played + ", strength_attack_away = " + strength_attack_away + ", points = " + points + ", loss = " + loss + ", strength_defence_home = " + strength_defence_home + ", form = " + form + ", strength_attack_home = " + strength_attack_home + ", strength_overall_home = " + strength_overall_home + ", name = " + name + ", short_name = " + short_name + ", id = " + id + ", position = " + position + ", win = " + win + "]";
    }
}
