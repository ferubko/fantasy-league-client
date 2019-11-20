package com.learn.fantasy.dto.leagueMemberContent;

import java.util.List;

/**
 * Created by stepanferubko
 */
public class Leagues {
    private List<Classic> classic;
    private List<String> h2h;

    public List<Classic> getClassic() {
        return classic;
    }

    public void setClassic(List<Classic> classic) {
        this.classic = classic;
    }

    public List<String> getH2h() {
        return h2h;
    }

    public void setH2h(List<String> h2h) {
        this.h2h = h2h;
    }

    @Override
    public String toString() {
        return "Leagues{" +
                "classic=" + classic +
                ", h2h=" + h2h +
                '}';
    }
}
