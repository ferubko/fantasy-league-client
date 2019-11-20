package com.learn.fantasy.dto.leagueMemberContent;

import java.util.Date;

/**
 * Created by stepanferubko
 */
public class MemberContent {
    private Long id;
    private int last_deadline_total_transfers;
    private int favourite_team;
    private Date joined_time;
    private Leagues leagues;
    private int summary_overall_points;
    private int current_event;
    private String player_region_iso_code_short;
    private String player_region_name;
    private int last_deadline_value;
    private String player_last_name;
    private String player_region_iso_code_long;
    private int summary_overall_rank;
    private int last_deadline_bank;
    private int summary_event_points;
    private String kit;
    private String name;
    private int started_event;
    private String player_first_name;
    private int player_region_id;
    private int summary_event_rank;

    public int getLast_deadline_total_transfers() {
        return last_deadline_total_transfers;
    }

    public void setLast_deadline_total_transfers(int last_deadline_total_transfers) {
        this.last_deadline_total_transfers = last_deadline_total_transfers;
    }

    public int getFavourite_team() {
        return favourite_team;
    }

    public void setFavourite_team(int favourite_team) {
        this.favourite_team = favourite_team;
    }

    public Date getJoined_time() {
        return joined_time;
    }

    public void setJoined_time(Date joined_time) {
        this.joined_time = joined_time;
    }

    public Leagues getLeagues() {
        return leagues;
    }

    public void setLeagues(Leagues leagues) {
        this.leagues = leagues;
    }

    public int getSummary_overall_points() {
        return summary_overall_points;
    }

    public void setSummary_overall_points(int summary_overall_points) {
        this.summary_overall_points = summary_overall_points;
    }

    public int getCurrent_event() {
        return current_event;
    }

    public void setCurrent_event(int current_event) {
        this.current_event = current_event;
    }

    public String getPlayer_region_iso_code_short() {
        return player_region_iso_code_short;
    }

    public void setPlayer_region_iso_code_short(String player_region_iso_code_short) {
        this.player_region_iso_code_short = player_region_iso_code_short;
    }

    public String getPlayer_region_name() {
        return player_region_name;
    }

    public void setPlayer_region_name(String player_region_name) {
        this.player_region_name = player_region_name;
    }

    public int getLast_deadline_value() {
        return last_deadline_value;
    }

    public void setLast_deadline_value(int last_deadline_value) {
        this.last_deadline_value = last_deadline_value;
    }

    public String getPlayer_last_name() {
        return player_last_name;
    }

    public void setPlayer_last_name(String player_last_name) {
        this.player_last_name = player_last_name;
    }

    public String getPlayer_region_iso_code_long() {
        return player_region_iso_code_long;
    }

    public void setPlayer_region_iso_code_long(String player_region_iso_code_long) {
        this.player_region_iso_code_long = player_region_iso_code_long;
    }

    public int getSummary_overall_rank() {
        return summary_overall_rank;
    }

    public void setSummary_overall_rank(int summary_overall_rank) {
        this.summary_overall_rank = summary_overall_rank;
    }

    public int getLast_deadline_bank() {
        return last_deadline_bank;
    }

    public void setLast_deadline_bank(int last_deadline_bank) {
        this.last_deadline_bank = last_deadline_bank;
    }

    public int getSummary_event_points() {
        return summary_event_points;
    }

    public void setSummary_event_points(int summary_event_points) {
        this.summary_event_points = summary_event_points;
    }

    public String getKit() {
        return kit;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStarted_event() {
        return started_event;
    }

    public void setStarted_event(int started_event) {
        this.started_event = started_event;
    }

    public String getPlayer_first_name() {
        return player_first_name;
    }

    public void setPlayer_first_name(String player_first_name) {
        this.player_first_name = player_first_name;
    }

    public int getPlayer_region_id() {
        return player_region_id;
    }

    public void setPlayer_region_id(int player_region_id) {
        this.player_region_id = player_region_id;
    }

    public int getSummary_event_rank() {
        return summary_event_rank;
    }

    public void setSummary_event_rank(int summary_event_rank) {
        this.summary_event_rank = summary_event_rank;
    }

    @Override
    public String toString() {
        return "MemberContent{" +
                "id=" + id +
                ", last_deadline_total_transfers=" + last_deadline_total_transfers +
                ", favourite_team=" + favourite_team +
                ", joined_time=" + joined_time +
                ", leagues=" + leagues +
                ", summary_overall_points=" + summary_overall_points +
                ", current_event=" + current_event +
                ", player_region_iso_code_short='" + player_region_iso_code_short + '\'' +
                ", player_region_name='" + player_region_name + '\'' +
                ", last_deadline_value=" + last_deadline_value +
                ", player_last_name='" + player_last_name + '\'' +
                ", player_region_iso_code_long='" + player_region_iso_code_long + '\'' +
                ", summary_overall_rank=" + summary_overall_rank +
                ", last_deadline_bank=" + last_deadline_bank +
                ", summary_event_points=" + summary_event_points +
                ", kit='" + kit + '\'' +
                ", name='" + name + '\'' +
                ", started_event=" + started_event +
                ", player_first_name='" + player_first_name + '\'' +
                ", player_region_id=" + player_region_id +
                ", summary_event_rank=" + summary_event_rank +
                '}';
    }
}
