package com.learn.fantasy.dto.legueInfo;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class New_entries {
    private boolean has_next;

    private int page;

    private List<String> results;

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

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "New_entries{" +
                "has_next='" + has_next + '\'' +
                ", page='" + page + '\'' +
                ", results=" + results +
                '}';
    }
}
