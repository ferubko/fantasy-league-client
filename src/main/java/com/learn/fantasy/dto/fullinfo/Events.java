package com.learn.fantasy.dto.fullinfo;

import java.util.Date;
import java.util.List;

/**
 * Created by stepanferubko
 */
public class Events {
    private long id;
    private boolean data_checked;
    private int deadline_time_game_offset;
    private int average_entry_score;
    private boolean is_previous;
    private int most_selected;
    private int most_transferred_in;
    private boolean finished;
    private int most_captained;
    private List<Chip_plays> chip_plays;
    private int top_element;
    private Top_element_info top_element_info;
    private boolean is_next;
    private int most_vice_captained;
    private long deadline_time_epoch;
    private String name;
    private Date deadline_time;
    private int transfers_made;
  private long highest_scoring_entry;
    private boolean is_current;
    private int highest_score;

    public boolean isData_checked() {
        return data_checked;
    }

    public void setData_checked(boolean data_checked) {
        this.data_checked = data_checked;
    }

    public int getDeadline_time_game_offset() {
        return deadline_time_game_offset;
    }

    public void setDeadline_time_game_offset(int deadline_time_game_offset) {
        this.deadline_time_game_offset = deadline_time_game_offset;
    }

    public int getAverage_entry_score() {
        return average_entry_score;
    }

    public void setAverage_entry_score(int average_entry_score) {
        this.average_entry_score = average_entry_score;
    }

    public boolean is_previous() {
        return is_previous;
    }

    public void setIs_previous(boolean is_previous) {
        this.is_previous = is_previous;
    }

    public int getMost_selected() {
        return most_selected;
    }

    public void setMost_selected(int most_selected) {
        this.most_selected = most_selected;
    }

    public int getMost_transferred_in() {
        return most_transferred_in;
    }

    public void setMost_transferred_in(int most_transferred_in) {
        this.most_transferred_in = most_transferred_in;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getMost_captained() {
        return most_captained;
    }

    public void setMost_captained(int most_captained) {
        this.most_captained = most_captained;
    }

    public List<Chip_plays> getChip_plays() {
        return chip_plays;
    }

    public void setChip_plays(List<Chip_plays> chip_plays) {
        this.chip_plays = chip_plays;
    }

    public int getTop_element() {
        return top_element;
    }

    public void setTop_element(int top_element) {
        this.top_element = top_element;
    }

    public Top_element_info getTop_element_info() {
        return top_element_info;
    }

    public void setTop_element_info(Top_element_info top_element_info) {
        this.top_element_info = top_element_info;
    }

    public boolean is_next() {
        return is_next;
    }

    public void setIs_next(boolean is_next) {
        this.is_next = is_next;
    }

    public int getMost_vice_captained() {
        return most_vice_captained;
    }

    public void setMost_vice_captained(int most_vice_captained) {
        this.most_vice_captained = most_vice_captained;
    }

    public long getDeadline_time_epoch() {
        return deadline_time_epoch;
    }

    public void setDeadline_time_epoch(long deadline_time_epoch) {
        this.deadline_time_epoch = deadline_time_epoch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline_time() {
        return deadline_time;
    }

    public void setDeadline_time(Date deadline_time) {
        this.deadline_time = deadline_time;
    }

    public int getTransfers_made() {
        return transfers_made;
    }

    public void setTransfers_made(int transfers_made) {
        this.transfers_made = transfers_made;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHighest_scoring_entry() {
        return highest_scoring_entry;
    }

    public void setHighest_scoring_entry(long highest_scoring_entry) {
        this.highest_scoring_entry = highest_scoring_entry;
    }

    public boolean is_current() {
        return is_current;
    }

    public void setIs_current(boolean is_current) {
        this.is_current = is_current;
    }

    public int getHighest_score() {
        return highest_score;
    }

    public void setHighest_score(int highest_score) {
        this.highest_score = highest_score;
    }

    @Override
    public String toString() {
        return "Events{" +
                "data_checked=" + data_checked +
                ", deadline_time_game_offset=" + deadline_time_game_offset +
                ", average_entry_score=" + average_entry_score +
                ", is_previous=" + is_previous +
                ", most_selected=" + most_selected +
                ", most_transferred_in=" + most_transferred_in +
                ", finished=" + finished +
                ", most_captained=" + most_captained +
                ", chip_plays=" + chip_plays +
                ", top_element=" + top_element +
                ", top_element_info=" + top_element_info +
                ", is_next=" + is_next +
                ", most_vice_captained=" + most_vice_captained +
                ", deadline_time_epoch=" + deadline_time_epoch +
                ", name='" + name + '\'' +
                ", deadline_time=" + deadline_time +
                ", transfers_made=" + transfers_made +
                ", id=" + id +
                ", highest_scoring_entry=" + highest_scoring_entry +
                ", is_current=" + is_current +
                ", highest_score=" + highest_score +
                '}';
    }
}
