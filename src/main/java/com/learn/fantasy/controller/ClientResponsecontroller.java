package com.learn.fantasy.controller;

import com.learn.fantasy.client.PremierLeaguApiClient;
import com.learn.fantasy.controller.client.AbstractController;
import com.learn.fantasy.service.LeagueService;
import com.learn.fantasy.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/api")
public class ClientResponsecontroller extends AbstractController {
    private static String jsessionid;

    @Autowired
    private MigrationService migrationService;
    @Autowired
    private PremierLeaguApiClient premierLeaguApiClient;

    @RequestMapping(value = "/fullInformation", method = RequestMethod.GET)
    public String getFullInformation() {
        return premierLeaguApiClient.getFullInformation().toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return premierLeaguApiClient.login();
    }

    @RequestMapping(value = "/leagueInformation", method = RequestMethod.GET)
    public String getLeagueInformation() {
        return premierLeaguApiClient.getLeagueInformation().toString();
    }


    @RequestMapping(value = "/full", method = RequestMethod.GET)
    public String saveFull() {
        migrationService.saveAplInformation();
        return "SUCCESS";
    }
}
