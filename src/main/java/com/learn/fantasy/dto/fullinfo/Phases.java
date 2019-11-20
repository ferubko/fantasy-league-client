package com.learn.fantasy.dto.fullinfo;

/**
 * Created by stepanferubko
 */
public class Phases {
    private int start_event;
    private int stop_event;
    private String name;
    private long id;

    public int getStart_event() {
        return start_event;
    }

    public void setStart_event(int start_event) {
        this.start_event = start_event;
    }

    public int getStop_event() {
        return stop_event;
    }

    public void setStop_event(int stop_event) {
        this.stop_event = stop_event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Phases{" +
                "start_event=" + start_event +
                ", stop_event=" + stop_event +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
