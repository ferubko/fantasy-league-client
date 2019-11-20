package com.learn.fantasy.dto.fullinfo;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Element_types {
    private long id;
    private String singular_name;
    private int squad_min_play;
    private int squad_select;
    private int squad_max_play;
    private boolean ui_shirt_specific;
    private String singular_name_short;
    private String plural_name;
    private String plural_name_short;
    private List<Integer> sub_positions_locked;

    public String getSingular_name() {
        return singular_name;
    }

    public void setSingular_name(String singular_name) {
        this.singular_name = singular_name;
    }

    public int getSquad_min_play() {
        return squad_min_play;
    }

    public void setSquad_min_play(int squad_min_play) {
        this.squad_min_play = squad_min_play;
    }

    public int getSquad_select() {
        return squad_select;
    }

    public void setSquad_select(int squad_select) {
        this.squad_select = squad_select;
    }

    public int getSquad_max_play() {
        return squad_max_play;
    }

    public void setSquad_max_play(int squad_max_play) {
        this.squad_max_play = squad_max_play;
    }

    public boolean isUi_shirt_specific() {
        return ui_shirt_specific;
    }

    public void setUi_shirt_specific(boolean ui_shirt_specific) {
        this.ui_shirt_specific = ui_shirt_specific;
    }

    public String getSingular_name_short() {
        return singular_name_short;
    }

    public void setSingular_name_short(String singular_name_short) {
        this.singular_name_short = singular_name_short;
    }

    public String getPlural_name() {
        return plural_name;
    }

    public void setPlural_name(String plural_name) {
        this.plural_name = plural_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlural_name_short() {
        return plural_name_short;
    }

    public void setPlural_name_short(String plural_name_short) {
        this.plural_name_short = plural_name_short;
    }

    public List<Integer> getSub_positions_locked() {
        return sub_positions_locked;
    }

    public void setSub_positions_locked(List<Integer> sub_positions_locked) {
        this.sub_positions_locked = sub_positions_locked;
    }

    @Override
    public String toString() {
        return "Element_types{" +
                "singular_name='" + singular_name + '\'' +
                ", squad_min_play=" + squad_min_play +
                ", squad_select=" + squad_select +
                ", squad_max_play=" + squad_max_play +
                ", ui_shirt_specific=" + ui_shirt_specific +
                ", singular_name_short='" + singular_name_short + '\'' +
                ", plural_name='" + plural_name + '\'' +
                ", id=" + id +
                ", plural_name_short='" + plural_name_short + '\'' +
                ", sub_positions_locked=" + sub_positions_locked +
                '}';
    }
}
