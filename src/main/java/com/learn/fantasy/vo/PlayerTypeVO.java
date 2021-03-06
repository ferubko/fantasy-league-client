package com.learn.fantasy.vo;

import java.io.Serializable;

/**
 * Created by stepanferubko
 */
public class PlayerTypeVO implements Serializable {
    private Long id;
    private String pluralName;
    private String pluralShortName;
    private String singularName;
    private String singularShortName;
    private Integer squadSelect;
    private Integer squadMinPlay;
    private Integer squadMaxPlay;

    public PlayerTypeVO(Long id) {
        this.id = id;
    }

    public PlayerTypeVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getPluralShortName() {
        return pluralShortName;
    }

    public void setPluralShortName(String pluralShortName) {
        this.pluralShortName = pluralShortName;
    }

    public String getSingularName() {
        return singularName;
    }

    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

    public String getSingularShortName() {
        return singularShortName;
    }

    public void setSingularShortName(String singularShortName) {
        this.singularShortName = singularShortName;
    }

    public Integer getSquadSelect() {
        return squadSelect;
    }

    public void setSquadSelect(Integer squadSelect) {
        this.squadSelect = squadSelect;
    }

    public Integer getSquadMinPlay() {
        return squadMinPlay;
    }

    public void setSquadMinPlay(Integer squadMinPlay) {
        this.squadMinPlay = squadMinPlay;
    }

    public Integer getSquadMaxPlay() {
        return squadMaxPlay;
    }

    public void setSquadMaxPlay(Integer squadMaxPlay) {
        this.squadMaxPlay = squadMaxPlay;
    }


    @Override
    public String toString() {
        return "PlayerTypeVO{" +
                "id=" + id +
                ", pluralName='" + pluralName + '\'' +
                ", pluralShortName='" + pluralShortName + '\'' +
                ", singularName='" + singularName + '\'' +
                ", singularShortName='" + singularShortName + '\'' +
                ", squadSelect=" + squadSelect +
                ", squadMinPlay=" + squadMinPlay +
                ", squadMaxPlay=" + squadMaxPlay +
                '}';
    }
}
