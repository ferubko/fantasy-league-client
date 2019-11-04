package com.learn.fantasy.dto.fullinfo;

/**
 * Created by stepanferubko
 */
public class Element_stats {
    private String label;
    private String name;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element_stats{" +
                "label='" + label + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
