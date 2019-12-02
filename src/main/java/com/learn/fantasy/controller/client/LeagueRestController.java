package com.learn.fantasy.controller.client;

import com.learn.fantasy.service.LeagueService;
import com.learn.fantasy.vo.LeagueMemberVO;
import com.learn.fantasy.vo.LeagueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stepanferubko
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leagueMember")
public class LeagueRestController {

    @Autowired
    private LeagueService leagueService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
    public LeagueVO getAllLeagueMembers() {
        return leagueService.getLeagueMembers();
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.POST)
    public LeagueMemberVO getLeagueMemberDetails(@PathVariable("id") Long id) {
        return leagueService.getLeagueMemberDetails(id);
    }
}
