package com.learn.fantasy.client;

import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.dto.leagueMemberContent.MemberContent;
import com.learn.fantasy.dto.legueInfo.LeagueResponse;
import com.learn.fantasy.dto.memberPlayers.MemberPlayer;
import com.learn.fantasy.dto.player.Player;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.logging.Logger;

import static com.learn.fantasy.common.Constants.*;

/**
 * Created by stepanferubko
 */
@Component
public class PremierLeaguApiClient {
    private final static Logger LOG = Logger.getLogger(PremierLeaguApiClient.class.getName());


    private static String finalCookie = "pl_profile=eyJzIjogIld6SXNORFl6TURVMU1USmQ6MWkwMlJJOk1WdnBwT2hKdG5HZlctZmNPLWlfYnBwdzJNbyIsICJ1IjogeyJpZCI6IDQ2MzA1NTEyLCAiZm4iOiAiU3RlcGFuIiwgImxuIjogIkYiLCAiZmMiOiAxNH19; Domain=premierleague.com; expires=Tue, 03 Sep 2022 11:36:36 GMT; Max-Age=1209600; Path=/; Secure";

    @Autowired
    private RestTemplate restTemplate;

    public String login() {
        LOG.info("Login into FPL");
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String tempCookies = restTemplate.execute(FPL_LOGIN_URL, HttpMethod.POST,
                request -> {
                    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                    map.add("login", "sferubko@gmail.com");
                    map.add("password", new String(Base64.decodeBase64("dmRvcnQxN3chMQ=")));
                    map.add("app", "plfpl-web");
                    map.add("redirect_uri", "https://fantasy.premierleague.com/");
                    new FormHttpMessageConverter().write(map, MediaType.APPLICATION_FORM_URLENCODED, request);
                }, response -> response.getHeaders().getFirst(HttpHeaders.SET_COOKIE));
        finalCookie = tempCookies;
        return tempCookies;
    }

    public FullInfo getFullInformation() {
        LOG.info("Get fantasy full information");
        try {
            return restTemplate.getForObject(FPL_FULL_INFO_URL, FullInfo.class);
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public LeagueResponse getLeagueInformation() {
        LOG.info("Get fantasy league information");
        try {
            HttpHeaders requestHeaders = getHttpHeaders();

            HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
            HttpEntity<LeagueResponse> rssResponse = restTemplate.exchange(
                    FPL_LEAGUE_INFO_URL,
                    HttpMethod.GET,
                    requestEntity,
                    LeagueResponse.class);
            LeagueResponse body = rssResponse.getBody();
            return body;
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());

            throw new RuntimeException(ex.getMessage());
        }
    }

    public MemberContent getMemberDetails(Long memberId) {
        LOG.info("Get league member details: " + memberId);
        try {
            HttpHeaders requestHeaders = getHttpHeaders();
            String url = String.format(FPL_MEMBER_CONTENT, memberId);
            LOG.info("Connect to link: " + url);

            HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
            HttpEntity<MemberContent> rssResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    MemberContent.class);
            return rssResponse.getBody();
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public MemberPlayer getMemberPlayerIds(Long memberId, Integer currentWeek) {
        LOG.info("Get league members players: " + memberId + " current week " + currentWeek);
        try {
            HttpHeaders requestHeaders = getHttpHeaders();
            String url = String.format(FPL_MEMBER_PICKS, memberId, currentWeek);
            LOG.info("Connect to link: " + url);

            HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
            HttpEntity<MemberPlayer> rssResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    MemberPlayer.class);
            return rssResponse.getBody();
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Player getPlayerHistoty(Long playerId) {
        LOG.info("Get player History: " + playerId);
        try {
            HttpHeaders requestHeaders = getHttpHeaders();
            String url = String.format(FPL_PLAYER_HISTORY, playerId);
            LOG.info("Connect to link: " + url);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
            HttpEntity<Player> rssResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    Player.class);
            return rssResponse.getBody();
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Cookie", finalCookie);
        requestHeaders.add("Sec-Fetch-User", "?1");
        requestHeaders.add("cache-control", "no-cache");
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return requestHeaders;
    }
}
