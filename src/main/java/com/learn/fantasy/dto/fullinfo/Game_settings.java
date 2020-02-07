package com.learn.fantasy.dto.fullinfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Game_settings {
    private String league_join_private_max;
    private String league_join_public_max;
    private String league_max_size_public_classic;
    private String league_max_size_public_h2h;
    private String league_max_size_private_h2h;
    private String league_max_ko_rounds_private_h2h;
    private String league_prefix_public;
    private String league_points_h2h_win;
    private String league_points_h2h_lose;
    private String league_points_h2h_draw;
    private boolean league_ko_first_instead_of_random;
    private String cup_start_event_id;
    private String cup_qualifying_method;
    private String cup_type;
    private String squad_squadplay;
    private String squad_squadsize;
    private String squad_team_limit;
    private String squad_total_spend;
    private String ui_currency_multiplier;
    private String ui_use_special_shirts;
    @JsonProperty("ui_special_shirt_exclusions")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> ui_special_shirt_exclusions;
    private String stats_form_days;
    private String sys_vice_captain_enabled;
    private String transfers_sell_on_fee;
    @JsonProperty("league_h2h_tiebreak_stats")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> league_h2h_tiebreak_stats;
    private String timezone;

    public String getLeague_join_private_max() {
        return league_join_private_max;
    }

    public void setLeague_join_private_max(String league_join_private_max) {
        this.league_join_private_max = league_join_private_max;
    }

    public String getLeague_join_public_max() {
        return league_join_public_max;
    }

    public void setLeague_join_public_max(String league_join_public_max) {
        this.league_join_public_max = league_join_public_max;
    }

    public String getLeague_max_size_public_classic() {
        return league_max_size_public_classic;
    }

    public void setLeague_max_size_public_classic(String league_max_size_public_classic) {
        this.league_max_size_public_classic = league_max_size_public_classic;
    }

    public String getLeague_max_size_public_h2h() {
        return league_max_size_public_h2h;
    }

    public void setLeague_max_size_public_h2h(String league_max_size_public_h2h) {
        this.league_max_size_public_h2h = league_max_size_public_h2h;
    }

    public String getLeague_max_size_private_h2h() {
        return league_max_size_private_h2h;
    }

    public void setLeague_max_size_private_h2h(String league_max_size_private_h2h) {
        this.league_max_size_private_h2h = league_max_size_private_h2h;
    }

    public String getLeague_max_ko_rounds_private_h2h() {
        return league_max_ko_rounds_private_h2h;
    }

    public void setLeague_max_ko_rounds_private_h2h(String league_max_ko_rounds_private_h2h) {
        this.league_max_ko_rounds_private_h2h = league_max_ko_rounds_private_h2h;
    }

    public String getLeague_prefix_public() {
        return league_prefix_public;
    }

    public void setLeague_prefix_public(String league_prefix_public) {
        this.league_prefix_public = league_prefix_public;
    }

    public String getLeague_points_h2h_win() {
        return league_points_h2h_win;
    }

    public void setLeague_points_h2h_win(String league_points_h2h_win) {
        this.league_points_h2h_win = league_points_h2h_win;
    }

    public String getLeague_points_h2h_lose() {
        return league_points_h2h_lose;
    }

    public void setLeague_points_h2h_lose(String league_points_h2h_lose) {
        this.league_points_h2h_lose = league_points_h2h_lose;
    }

    public String getLeague_points_h2h_draw() {
        return league_points_h2h_draw;
    }

    public void setLeague_points_h2h_draw(String league_points_h2h_draw) {
        this.league_points_h2h_draw = league_points_h2h_draw;
    }

    public boolean isLeague_ko_first_instead_of_random() {
        return league_ko_first_instead_of_random;
    }

    public void setLeague_ko_first_instead_of_random(boolean league_ko_first_instead_of_random) {
        this.league_ko_first_instead_of_random = league_ko_first_instead_of_random;
    }

    public String getCup_start_event_id() {
        return cup_start_event_id;
    }

    public void setCup_start_event_id(String cup_start_event_id) {
        this.cup_start_event_id = cup_start_event_id;
    }

    public String getCup_qualifying_method() {
        return cup_qualifying_method;
    }

    public void setCup_qualifying_method(String cup_qualifying_method) {
        this.cup_qualifying_method = cup_qualifying_method;
    }

    public String getCup_type() {
        return cup_type;
    }

    public void setCup_type(String cup_type) {
        this.cup_type = cup_type;
    }

    public String getSquad_squadplay() {
        return squad_squadplay;
    }

    public void setSquad_squadplay(String squad_squadplay) {
        this.squad_squadplay = squad_squadplay;
    }

    public String getSquad_squadsize() {
        return squad_squadsize;
    }

    public void setSquad_squadsize(String squad_squadsize) {
        this.squad_squadsize = squad_squadsize;
    }

    public String getSquad_team_limit() {
        return squad_team_limit;
    }

    public void setSquad_team_limit(String squad_team_limit) {
        this.squad_team_limit = squad_team_limit;
    }

    public String getSquad_total_spend() {
        return squad_total_spend;
    }

    public void setSquad_total_spend(String squad_total_spend) {
        this.squad_total_spend = squad_total_spend;
    }

    public String getUi_currency_multiplier() {
        return ui_currency_multiplier;
    }

    public void setUi_currency_multiplier(String ui_currency_multiplier) {
        this.ui_currency_multiplier = ui_currency_multiplier;
    }

    public String getUi_use_special_shirts() {
        return ui_use_special_shirts;
    }

    public void setUi_use_special_shirts(String ui_use_special_shirts) {
        this.ui_use_special_shirts = ui_use_special_shirts;
    }

    public List<String> getUi_special_shirt_exclusions() {
        return ui_special_shirt_exclusions;
    }

    public void setUi_special_shirt_exclusions(List<String> ui_special_shirt_exclusions) {
        this.ui_special_shirt_exclusions = ui_special_shirt_exclusions;
    }

    public String getStats_form_days() {
        return stats_form_days;
    }

    public void setStats_form_days(String stats_form_days) {
        this.stats_form_days = stats_form_days;
    }

    public String getSys_vice_captain_enabled() {
        return sys_vice_captain_enabled;
    }

    public void setSys_vice_captain_enabled(String sys_vice_captain_enabled) {
        this.sys_vice_captain_enabled = sys_vice_captain_enabled;
    }

    public String getTransfers_sell_on_fee() {
        return transfers_sell_on_fee;
    }

    public void setTransfers_sell_on_fee(String transfers_sell_on_fee) {
        this.transfers_sell_on_fee = transfers_sell_on_fee;
    }

    public List<String> getLeague_h2h_tiebreak_stats() {
        return league_h2h_tiebreak_stats;
    }

    public void setLeague_h2h_tiebreak_stats(List<String> league_h2h_tiebreak_stats) {
        this.league_h2h_tiebreak_stats = league_h2h_tiebreak_stats;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Game_settings{" +
                "league_join_private_max='" + league_join_private_max + '\'' +
                ", league_join_public_max='" + league_join_public_max + '\'' +
                ", league_max_size_public_classic='" + league_max_size_public_classic + '\'' +
                ", league_max_size_public_h2h='" + league_max_size_public_h2h + '\'' +
                ", league_max_size_private_h2h='" + league_max_size_private_h2h + '\'' +
                ", league_max_ko_rounds_private_h2h='" + league_max_ko_rounds_private_h2h + '\'' +
                ", league_prefix_public='" + league_prefix_public + '\'' +
                ", league_points_h2h_win='" + league_points_h2h_win + '\'' +
                ", league_points_h2h_lose='" + league_points_h2h_lose + '\'' +
                ", league_points_h2h_draw='" + league_points_h2h_draw + '\'' +
                ", league_ko_first_instead_of_random=" + league_ko_first_instead_of_random +
                ", cup_start_event_id='" + cup_start_event_id + '\'' +
                ", cup_qualifying_method='" + cup_qualifying_method + '\'' +
                ", cup_type='" + cup_type + '\'' +
                ", squad_squadplay='" + squad_squadplay + '\'' +
                ", squad_squadsize='" + squad_squadsize + '\'' +
                ", squad_team_limit='" + squad_team_limit + '\'' +
                ", squad_total_spend='" + squad_total_spend + '\'' +
                ", ui_currency_multiplier='" + ui_currency_multiplier + '\'' +
                ", ui_use_special_shirts='" + ui_use_special_shirts + '\'' +
                ", ui_special_shirt_exclusions=" + ui_special_shirt_exclusions +
                ", stats_form_days='" + stats_form_days + '\'' +
                ", sys_vice_captain_enabled='" + sys_vice_captain_enabled + '\'' +
                ", transfers_sell_on_fee='" + transfers_sell_on_fee + '\'' +
                ", league_h2h_tiebreak_stats=" + league_h2h_tiebreak_stats +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
