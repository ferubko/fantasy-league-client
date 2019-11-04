package com.learn.fantasy.controller.client;

import com.learn.fantasy.service.LeagueService;
import com.learn.fantasy.vo.LeagueMemberVO;
import com.learn.fantasy.vo.LeagueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/leagueMember")
//@CrossOrigin(origins = "http://localhost:4200")
public class LeagueRestController {

    @Autowired
    private LeagueService leagueService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public LeagueVO getAllLeagueMembers() {
        return leagueService.getLeagueMembers();
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public LeagueMemberVO getLeagueMemberDetails(@PathVariable("id") Long id) {
        return leagueService.getLeagueMemberDetails(id);
    }
}
