package com.learn.fantasy.dto.player;

import java.util.Date;

/**
 * Created by stepanferubko
 */
public class Fixtures {
    private long code;
    private boolean is_home;
    private boolean provisional_start_time;
    private int minutes;
    private Date kickoff_time;
    private int team_h;
    private boolean finished;
    private String team_a_score;
    private int team_a;
    private int difficulty;
    private String event_name;
    private int event;
    private String team_h_score;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean is_home() {
        return is_home;
    }

    public void setIs_home(boolean is_home) {
        this.is_home = is_home;
    }

    public boolean isProvisional_start_time() {
        return provisional_start_time;
    }

    public void setProvisional_start_time(boolean provisional_start_time) {
        this.provisional_start_time = provisional_start_time;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Date getKickoff_time() {
        return kickoff_time;
    }

    public void setKickoff_time(Date kickoff_time) {
        this.kickoff_time = kickoff_time;
    }

    public int getTeam_h() {
        return team_h;
    }

    public void setTeam_h(int team_h) {
        this.team_h = team_h;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getTeam_a_score() {
        return team_a_score;
    }

    public void setTeam_a_score(String team_a_score) {
        this.team_a_score = team_a_score;
    }

    public int getTeam_a() {
        return team_a;
    }

    public void setTeam_a(int team_a) {
        this.team_a = team_a;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getTeam_h_score() {
        return team_h_score;
    }

    public void setTeam_h_score(String team_h_score) {
        this.team_h_score = team_h_score;
    }

    @Override
    public String toString() {
        return "Fixtures{" +
                "code=" + code +
                ", is_home=" + is_home +
                ", provisional_start_time=" + provisional_start_time +
                ", minutes=" + minutes +
                ", kickoff_time=" + kickoff_time +
                ", team_h=" + team_h +
                ", finished=" + finished +
                ", team_a_score='" + team_a_score + '\'' +
                ", team_a=" + team_a +
                ", difficulty=" + difficulty +
                ", event_name='" + event_name + '\'' +
                ", event=" + event +
                ", team_h_score='" + team_h_score + '\'' +
                '}';
    }
}
