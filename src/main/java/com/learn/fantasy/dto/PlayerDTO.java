package com.learn.fantasy.dto;

import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by stepanferubko
 */
public class PlayerDTO {
    private Map<Long, List<Elements>> playersMapping;
    private FullInfo fullInformation;

    public Map<Long, List<Elements>> getPlayersMapping() {
        return playersMapping;
    }

    public void setPlayersMapping(Map<Long, List<Elements>> playersMapping) {
        this.playersMapping = playersMapping;
    }

    public FullInfo getFullInformation() {
        return fullInformation;
    }

    public void setFullInformation(FullInfo fullInformation) {
        this.fullInformation = fullInformation;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "playersMapping=" + playersMapping +
                ", fullInformation=" + fullInformation +
                '}';
    }
}
