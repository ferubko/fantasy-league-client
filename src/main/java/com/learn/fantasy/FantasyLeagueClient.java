package com.learn.fantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by stepanferubko
 */
@SpringBootApplication
@EnableScheduling
public class FantasyLeagueClient {

    public static void main(String[] args) {
        SpringApplication.run(FantasyLeagueClient.class, args);
    }
}
