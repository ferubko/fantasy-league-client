package com.learn.fantasy.vo;

import java.io.Serializable;

/**
 * Created by stepanferubko
 */
public class TeamVO implements Serializable {
    private Long id;
    private String name;
    private String shortName;
    private Integer strength;

    public TeamVO(Long id) {
        this.id = id;
    }

    public TeamVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamVO team = (TeamVO) o;

        if (id != null ? !id.equals(team.id) : team.id != null) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (shortName != null ? !shortName.equals(team.shortName) : team.shortName != null) return false;
        return (strength != null ? !strength.equals(team.strength) : team.strength != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (strength != null ? strength.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", strength=" + strength +
                '}';
    }
}

