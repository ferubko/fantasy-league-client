package com.learn.fantasy.controller.client;

import com.learn.fantasy.dto.request.PlayerSearchRequest;
import com.learn.fantasy.service.PlayersService;
import com.learn.fantasy.vo.PlayerHistoryVO;
import com.learn.fantasy.vo.PlayerTypeVO;
import com.learn.fantasy.vo.PlayerVO;
import com.learn.fantasy.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/player")
//@CrossOrigin(origins = "http://localhost:4200")
public class PlayerRestController extends AbstractController {

    @Autowired
    private PlayersService playersService;

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    @CrossOrigin
    public List<PlayerTypeVO> getPlayerTypes() {
        return playersService.getPlayerTypes();
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    @CrossOrigin
    public List<TeamVO> getTeams() {
        return playersService.getTeams();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @CrossOrigin
    public List<PlayerVO> getPlayers() {
        return playersService.getPlayersEntity();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    @CrossOrigin
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
    public List<PlayerVO> getPlayers(@RequestBody PlayerSearchRequest playerSearchRequest) {
        return playersService.getPlayersEntityById(playerSearchRequest);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.POST)
//    @CrossOrigin
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
    public PlayerVO getPlayer(@PathVariable("id") Long playerId) {
        return playersService.getPlayerDetailsById(playerId);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<PlayerHistoryVO> getPlayerHistory() {
        return playersService.getPlayerHistory(192l);
    }
}
