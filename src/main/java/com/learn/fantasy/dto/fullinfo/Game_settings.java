package com.learn.fantasy.dto.fullinfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Game_settings {
    private String league_max_size_public_h2h;

    private String league_points_h2h_win;

    private String league_max_size_public_classic;

    private String timezone;

    private String league_join_public_max;
    @JsonProperty("ui_special_shirt_exclusions")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)

    private List<String> ui_special_shirt_exclusions;

    private String sys_vice_captain_enabled;

    private String cup_start_event_id;

    private String transfers_sell_on_fee;

    private String league_points_h2h_lose;

    private String squad_squadsize;

    private String squad_total_spend;

    private String ui_use_special_shirts;

    private String league_max_ko_rounds_private_h2h;

    private String league_join_private_max;

    private String squad_team_limit;

    private String league_prefix_public;

    private String league_points_h2h_draw;

    private String stats_form_days;

    private String ui_currency_multiplier;

    private String league_max_size_private_h2h;

    private String squad_squadplay;

    public String getLeague_max_size_public_h2h() {
        return league_max_size_public_h2h;
    }

    public void setLeague_max_size_public_h2h(String league_max_size_public_h2h) {
        this.league_max_size_public_h2h = league_max_size_public_h2h;
    }

    public String getLeague_points_h2h_win() {
        return league_points_h2h_win;
    }

    public void setLeague_points_h2h_win(String league_points_h2h_win) {
        this.league_points_h2h_win = league_points_h2h_win;
    }

    public String getLeague_max_size_public_classic() {
        return league_max_size_public_classic;
    }

    public void setLeague_max_size_public_classic(String league_max_size_public_classic) {
        this.league_max_size_public_classic = league_max_size_public_classic;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLeague_join_public_max() {
        return league_join_public_max;
    }

    public void setLeague_join_public_max(String league_join_public_max) {
        this.league_join_public_max = league_join_public_max;
    }

    public List<String> getUi_special_shirt_exclusions() {
        return ui_special_shirt_exclusions;
    }

    public void setUi_special_shirt_exclusions(List<String> ui_special_shirt_exclusions) {
        this.ui_special_shirt_exclusions = ui_special_shirt_exclusions;
    }

    public String getSys_vice_captain_enabled() {
        return sys_vice_captain_enabled;
    }

    public void setSys_vice_captain_enabled(String sys_vice_captain_enabled) {
        this.sys_vice_captain_enabled = sys_vice_captain_enabled;
    }

    public String getCup_start_event_id() {
        return cup_start_event_id;
    }

    public void setCup_start_event_id(String cup_start_event_id) {
        this.cup_start_event_id = cup_start_event_id;
    }

    public String getTransfers_sell_on_fee() {
        return transfers_sell_on_fee;
    }

    public void setTransfers_sell_on_fee(String transfers_sell_on_fee) {
        this.transfers_sell_on_fee = transfers_sell_on_fee;
    }

    public String getLeague_points_h2h_lose() {
        return league_points_h2h_lose;
    }

    public void setLeague_points_h2h_lose(String league_points_h2h_lose) {
        this.league_points_h2h_lose = league_points_h2h_lose;
    }

    public String getSquad_squadsize() {
        return squad_squadsize;
    }

    public void setSquad_squadsize(String squad_squadsize) {
        this.squad_squadsize = squad_squadsize;
    }

    public String getSquad_total_spend() {
        return squad_total_spend;
    }

    public void setSquad_total_spend(String squad_total_spend) {
        this.squad_total_spend = squad_total_spend;
    }

    public String getUi_use_special_shirts() {
        return ui_use_special_shirts;
    }

    public void setUi_use_special_shirts(String ui_use_special_shirts) {
        this.ui_use_special_shirts = ui_use_special_shirts;
    }

    public String getLeague_max_ko_rounds_private_h2h() {
        return league_max_ko_rounds_private_h2h;
    }

    public void setLeague_max_ko_rounds_private_h2h(String league_max_ko_rounds_private_h2h) {
        this.league_max_ko_rounds_private_h2h = league_max_ko_rounds_private_h2h;
    }

    public String getLeague_join_private_max() {
        return league_join_private_max;
    }

    public void setLeague_join_private_max(String league_join_private_max) {
        this.league_join_private_max = league_join_private_max;
    }

    public String getSquad_team_limit() {
        return squad_team_limit;
    }

    public void setSquad_team_limit(String squad_team_limit) {
        this.squad_team_limit = squad_team_limit;
    }

    public String getLeague_prefix_public() {
        return league_prefix_public;
    }

    public void setLeague_prefix_public(String league_prefix_public) {
        this.league_prefix_public = league_prefix_public;
    }

    public String getLeague_points_h2h_draw() {
        return league_points_h2h_draw;
    }

    public void setLeague_points_h2h_draw(String league_points_h2h_draw) {
        this.league_points_h2h_draw = league_points_h2h_draw;
    }

    public String getStats_form_days() {
        return stats_form_days;
    }

    public void setStats_form_days(String stats_form_days) {
        this.stats_form_days = stats_form_days;
    }

    public String getUi_currency_multiplier() {
        return ui_currency_multiplier;
    }

    public void setUi_currency_multiplier(String ui_currency_multiplier) {
        this.ui_currency_multiplier = ui_currency_multiplier;
    }

    public String getLeague_max_size_private_h2h() {
        return league_max_size_private_h2h;
    }

    public void setLeague_max_size_private_h2h(String league_max_size_private_h2h) {
        this.league_max_size_private_h2h = league_max_size_private_h2h;
    }

    public String getSquad_squadplay() {
        return squad_squadplay;
    }

    public void setSquad_squadplay(String squad_squadplay) {
        this.squad_squadplay = squad_squadplay;
    }

    @Override
    public String toString() {
        return "Game_settings{" +
                "league_max_size_public_h2h='" + league_max_size_public_h2h + '\'' +
                ", league_points_h2h_win='" + league_points_h2h_win + '\'' +
                ", league_max_size_public_classic='" + league_max_size_public_classic + '\'' +
                ", timezone='" + timezone + '\'' +
                ", league_join_public_max='" + league_join_public_max + '\'' +
                ", ui_special_shirt_exclusions=" + ui_special_shirt_exclusions +
                ", sys_vice_captain_enabled='" + sys_vice_captain_enabled + '\'' +
                ", cup_start_event_id='" + cup_start_event_id + '\'' +
                ", transfers_sell_on_fee='" + transfers_sell_on_fee + '\'' +
                ", league_points_h2h_lose='" + league_points_h2h_lose + '\'' +
                ", squad_squadsize='" + squad_squadsize + '\'' +
                ", squad_total_spend='" + squad_total_spend + '\'' +
                ", ui_use_special_shirts='" + ui_use_special_shirts + '\'' +
                ", league_max_ko_rounds_private_h2h='" + league_max_ko_rounds_private_h2h + '\'' +
                ", league_join_private_max='" + league_join_private_max + '\'' +
                ", squad_team_limit='" + squad_team_limit + '\'' +
                ", league_prefix_public='" + league_prefix_public + '\'' +
                ", league_points_h2h_draw='" + league_points_h2h_draw + '\'' +
                ", stats_form_days='" + stats_form_days + '\'' +
                ", ui_currency_multiplier='" + ui_currency_multiplier + '\'' +
                ", league_max_size_private_h2h='" + league_max_size_private_h2h + '\'' +
                ", squad_squadplay='" + squad_squadplay + '\'' +
                '}';
    }
}
