package com.learn.fantasy.dto.memberPlayers;

/**
 * Created by stepanferubko
 */
public class Automatic_subs {
    private long entry;
   private long element_out;
    private long element_in;
    private long event;

    public long getEntry() {
        return entry;
    }

    public void setEntry(long entry) {
        this.entry = entry;
    }

    public long getElement_out() {
        return element_out;
    }

    public void setElement_out(long element_out) {
        this.element_out = element_out;
    }

    public long getElement_in() {
        return element_in;
    }

    public void setElement_in(long element_in) {
        this.element_in = element_in;
    }

    public long getEvent() {
        return event;
    }

    public void setEvent(long event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Automatic_subs{" +
                "entry=" + entry +
                ", element_out=" + element_out +
                ", element_in=" + element_in +
                ", event=" + event +
                '}';
    }
}
