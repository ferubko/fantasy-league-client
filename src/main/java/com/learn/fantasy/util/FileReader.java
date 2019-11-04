package com.learn.fantasy.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.dto.legueInfo.LeagueResponse;

import java.io.File;
import java.io.IOException;

/**
 * Created by stepanferubko
 */
public class FileReader {
    public static FullInfo getFullInfo(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(url), FullInfo.class);
    }

    public static LeagueResponse read1(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(url), LeagueResponse.class);
    }
}
