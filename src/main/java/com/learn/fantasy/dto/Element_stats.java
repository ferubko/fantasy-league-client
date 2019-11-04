package com.learn.fantasy.dto;

/**
 * Created by stepanferubko
 */
public class Element_stats {
    private String name;

    private String label;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Element_stats{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
