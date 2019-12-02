package com.learn.fantasy.service;

import com.learn.fantasy.dto.request.PlayerSearchRequest;
import com.learn.fantasy.entity.Player;
import com.learn.fantasy.entity.PlayerHistory;
import com.learn.fantasy.entity.PlayerType;
import com.learn.fantasy.entity.Team;
import com.learn.fantasy.repository.PlayerHistoryRepository;
import com.learn.fantasy.repository.PlayerRepository;
import com.learn.fantasy.repository.PlayerTypeRepository;
import com.learn.fantasy.repository.TeamRepository;
import com.learn.fantasy.vo.PlayerHistoryVO;
import com.learn.fantasy.vo.PlayerTypeVO;
import com.learn.fantasy.vo.PlayerVO;
import com.learn.fantasy.vo.TeamVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
@Service
public class PlayersService {
    private final static Logger LOG = Logger.getLogger(PlayersService.class.getName());

    @Autowired
    private PlayerTypeRepository playerTypeRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerHistoryRepository playerHistoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "playerTypes")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<PlayerTypeVO> getPlayerTypes() {
        LOG.info("Get Player types");
        List<PlayerType> allTypes = playerTypeRepository.findAll();
        return allTypes.stream().map(type -> modelMapper.map(type, PlayerTypeVO.class)).collect(Collectors.toList());
    }

    @Cacheable(value = "teams")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<TeamVO> getTeams() {
        LOG.info("Get Teams");
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> modelMapper.map(team, TeamVO.class)).collect(Collectors.toList());
    }

    @Cacheable(value = "players")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<PlayerVO> getPlayersEntity() {
        LOG.info("Get Players");
        List<Player> players = playerRepository.findAll();
        return players.stream().map(player -> modelMapper.map(player, PlayerVO.class)).collect(Collectors.toList());
    }

    //    @Cacheable(value = "players")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<PlayerVO> getPlayersByIds(List<Long> ids) {
        LOG.info("Get Players by ids :" + ids.toString());
        List<Player> players = playerRepository.findByIdIn(ids);
        return players.stream().map(player -> modelMapper.map(player, PlayerVO.class)).collect(Collectors.toList());
    }

    //    @Cacheable(value = "playerHistories")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<PlayerHistoryVO> getPlayerHistory(Long id) {
        LOG.info("Get Player History by id :" + id);
        List<PlayerHistory> histories = playerHistoryRepository.findByPlayerId(id);
        return histories.stream().map(history -> modelMapper.map(history, PlayerHistoryVO.class)).collect(Collectors.toList());
    }

    @Cacheable(value = "playerDetails")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PlayerVO getPlayerDetailsById(Long playerId) {
        LOG.info("Get Player Details by id :" + playerId);
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            return modelMapper.map(player, PlayerVO.class);
        } else {
            LOG.info("There isno player");
            return new PlayerVO();
        }
    }

    @Transactional(readOnly = true)
    public List<PlayerVO> getPlayersEntityById(PlayerSearchRequest playerSearchRequest) {
        LOG.info("Search Player Details by playerSearchRequest");
        List<Player> players = new ArrayList<>();
        if (playerSearchRequest == null) {
            LOG.info("There is no request");
            players = playerRepository.findAll();
        } else {
            Long teamId = playerSearchRequest.getTeamId();
            Long playerTypeId = playerSearchRequest.getPlayerTypeId();
            LOG.info(String.format("PlayerVO selected: {%s}", playerSearchRequest.toString()));
            players = playerRepository.findByTeamIdAndPlayerType(teamId, playerTypeId);
        }

        List<PlayerVO> result = players.stream()
                .map(player -> modelMapper.map(player, PlayerVO.class))
                .sorted(Comparator.comparing(PlayerVO::getFirstName))
                .collect(Collectors.toList());
        return result;
    }

}
