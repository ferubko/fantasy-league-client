package com.learn.fantasy.dto.legueInfo;

import java.util.Date;

/**
 * Created by stepanferubko
 */
public class League {
    private long id;
    private String start_event;
    private long admin_entry;
    private String scoring;
    private String league_type;
    private Date created;
    private String name;
    private boolean closed;
    private int rank;
      private String code_privacy;
    private int max_entries;

    public League() {
    }

    public String getStart_event() {
        return start_event;
    }

    public void setStart_event(String start_event) {
        this.start_event = start_event;
    }

    public long getAdmin_entry() {
        return admin_entry;
    }

    public void setAdmin_entry(long admin_entry) {
        this.admin_entry = admin_entry;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }

    public String getLeague_type() {
        return league_type;
    }

    public void setLeague_type(String league_type) {
        this.league_type = league_type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode_privacy() {
        return code_privacy;
    }

    public void setCode_privacy(String code_privacy) {
        this.code_privacy = code_privacy;
    }

    public int getMax_entries() {
        return max_entries;
    }

    public void setMax_entries(int max_entries) {
        this.max_entries = max_entries;
    }

    @Override
    public String toString() {
        return "League{" +
                "start_event='" + start_event + '\'' +
                ", admin_entry='" + admin_entry + '\'' +
                ", scoring='" + scoring + '\'' +
                ", league_type='" + league_type + '\'' +
                ", created='" + created + '\'' +
                ", name='" + name + '\'' +
                ", closed='" + closed + '\'' +
                ", rank=" + rank +
                ", id='" + id + '\'' +
                ", code_privacy='" + code_privacy + '\'' +
                ", max_entries=" + max_entries +
                '}';
    }
}
