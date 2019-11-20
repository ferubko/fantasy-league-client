package com.learn.fantasy.dto.fullinfo;

/**
 * Created by stepanferubko
 */
public class Chip_plays {
    private String chip_name;
    private long num_played;

    public String getChip_name() {
        return chip_name;
    }

    public void setChip_name(String chip_name) {
        this.chip_name = chip_name;
    }

    public long getNum_played() {
        return num_played;
    }

    public void setNum_played(long num_played) {
        this.num_played = num_played;
    }

    @Override
    public String toString() {
        return "Chip_plays{" +
                "chip_name='" + chip_name + '\'' +
                ", num_played=" + num_played +
                '}';
    }
}
