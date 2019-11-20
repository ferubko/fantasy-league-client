package com.learn.fantasy.dto.leagueMemberContent;

import java.util.Date;

/**
 * Created by stepanferubko
 */
public class Classic {
    private Long id;
    private String admin_entry;
    private String scoring;
    private int entry_rank;
    private Date created;
    private int max_entries;
    private int start_event;
    private String league_type;
    private String name;
    private boolean closed;
    private int rank;
    private String entry_last_rank;
    private boolean entry_can_admin;
    private String short_name;
    private boolean entry_can_leave;
    private boolean entry_can_invite;

    public String getAdmin_entry() {
        return admin_entry;
    }

    public void setAdmin_entry(String admin_entry) {
        this.admin_entry = admin_entry;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }

    public int getEntry_rank() {
        return entry_rank;
    }

    public void setEntry_rank(int entry_rank) {
        this.entry_rank = entry_rank;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMax_entries() {
        return max_entries;
    }

    public void setMax_entries(int max_entries) {
        this.max_entries = max_entries;
    }

    public int getStart_event() {
        return start_event;
    }

    public void setStart_event(int start_event) {
        this.start_event = start_event;
    }

    public String getLeague_type() {
        return league_type;
    }

    public void setLeague_type(String league_type) {
        this.league_type = league_type;
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

    public String getEntry_last_rank() {
        return entry_last_rank;
    }

    public void setEntry_last_rank(String entry_last_rank) {
        this.entry_last_rank = entry_last_rank;
    }

    public boolean isEntry_can_admin() {
        return entry_can_admin;
    }

    public void setEntry_can_admin(boolean entry_can_admin) {
        this.entry_can_admin = entry_can_admin;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEntry_can_leave() {
        return entry_can_leave;
    }

    public void setEntry_can_leave(boolean entry_can_leave) {
        this.entry_can_leave = entry_can_leave;
    }

    public boolean isEntry_can_invite() {
        return entry_can_invite;
    }

    public void setEntry_can_invite(boolean entry_can_invite) {
        this.entry_can_invite = entry_can_invite;
    }

    @Override
    public String toString() {
        return "Classic{" +
                "id=" + id +
                ", admin_entry='" + admin_entry + '\'' +
                ", scoring='" + scoring + '\'' +
                ", entry_rank=" + entry_rank +
                ", created=" + created +
                ", max_entries=" + max_entries +
                ", start_event=" + start_event +
                ", league_type='" + league_type + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", rank=" + rank +
                ", entry_last_rank='" + entry_last_rank + '\'' +
                ", entry_can_admin=" + entry_can_admin +
                ", short_name='" + short_name + '\'' +
                ", entry_can_leave=" + entry_can_leave +
                ", entry_can_invite=" + entry_can_invite +
                '}';
    }
}
