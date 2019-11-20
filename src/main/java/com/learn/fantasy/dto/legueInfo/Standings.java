package com.learn.fantasy.dto.legueInfo;

import com.learn.fantasy.dto.Results;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Standings {
    private boolean has_next;
    private int page;
    private List<Results> results;

    public boolean isHas_next() {
        return has_next;
    }

    public void setHas_next(boolean has_next) {
        this.has_next = has_next;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Standings{" +
                "has_next='" + has_next + '\'' +
                ", page='" + page + '\'' +
                ", results=" + results +
                '}';
    }
}
