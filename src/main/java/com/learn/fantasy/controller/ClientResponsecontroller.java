package com.learn.fantasy.controller;

import com.learn.fantasy.client.PremierLeaguApiClient;
import com.learn.fantasy.controller.client.AbstractController;
import com.learn.fantasy.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/api")
public class ClientResponsecontroller extends AbstractController {

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
