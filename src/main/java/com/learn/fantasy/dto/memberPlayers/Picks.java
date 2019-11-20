package com.learn.fantasy.dto.memberPlayers;

/**
 * Created by stepanferubko
 */
public class Picks {
    private boolean is_captain;
    private long multiplier;
    private long position;
    private boolean is_vice_captain;
    private long element;

    public boolean is_captain() {
        return is_captain;
    }

    public void setIs_captain(boolean is_captain) {
        this.is_captain = is_captain;
    }

    public long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(long multiplier) {
        this.multiplier = multiplier;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public boolean is_vice_captain() {
        return is_vice_captain;
    }

    public void setIs_vice_captain(boolean is_vice_captain) {
        this.is_vice_captain = is_vice_captain;
    }

    public long getElement() {
        return element;
    }

    public void setElement(long element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Picks{" +
                "is_captain=" + is_captain +
                ", multiplier=" + multiplier +
                ", position=" + position +
                ", is_vice_captain=" + is_vice_captain +
                ", element=" + element +
                '}';
    }
}
