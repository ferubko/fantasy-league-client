package com.learn.fantasy.service;

import com.learn.fantasy.client.PremierLeaguApiClient;
import com.learn.fantasy.dto.Results;
import com.learn.fantasy.dto.fullinfo.Element_types;
import com.learn.fantasy.dto.fullinfo.Elements;
import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.dto.fullinfo.Teams;
import com.learn.fantasy.dto.legueInfo.League;
import com.learn.fantasy.dto.legueInfo.LeagueResponse;
import com.learn.fantasy.dto.player.History;
import com.learn.fantasy.entity.*;
import com.learn.fantasy.repository.*;
import com.learn.fantasy.util.FileReader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.learn.fantasy.common.Constants.FAILURE;
import static com.learn.fantasy.common.Constants.SUCCESS;

/**
 * Created by stepanferubko
 */
@Service
public class MigrationService {
    private final static Logger LOG = Logger.getLogger(MigrationService.class.getName());
    @Autowired
    private PremierLeaguApiClient premierLeaguApiClient;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerHistoryRepository playerHistoryRepository;
    @Autowired
    public PlayerTypeRepository playerTypeRepository;
    @Autowired
    private LeagueRepository leagueRepository;

    public void saveAplInformation() {
        try {
            FullInfo fullInformation = getFullInfo();
            if (fullInformation != null) {
                getLeagueMembers();
                String teamSaveStatus = fillTeamContent(fullInformation);
                String playerTypeSaveStatus = fillPlayerTypes(fullInformation);
                String playerSaveStatus = fillPlayerContent(fullInformation, null);
                String playerHistorySaveStatus = fillPlayerHistory();
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    public String convertJsonToObject() {
        try {
            LeagueResponse leagueResponse = FileReader.read1("/home/stepanferubko/learn/fantasy-league-client/src/test/resources/legueInfo1.json");
            League league = leagueResponse.getLeague();
            com.learn.fantasy.entity.League league1 = new com.learn.fantasy.entity.League();
            league1.setId(league.getId());
            league1.setName(league.getName());
            league1.setCreatedDate(league.getCreated());
            List<Results> results = leagueResponse.getStandings().getResults();
            List<LeagueMember> leagueMembers = results.stream().map(r -> {
                LeagueMember leagueMember = new LeagueMember();
                leagueMember.setId(r.getId());
                leagueMember.setEventTotal(r.getEvent_total());
                leagueMember.setPlayerName(r.getPlayer_name());
                leagueMember.setRank(r.getRank());
                leagueMember.setLastRank(r.getLast_rank());
                leagueMember.setRankSort(r.getRank_sort());
                leagueMember.setTotal(r.getTotal());
                leagueMember.setEntry(r.getEntry());
                leagueMember.setEntryName(r.getEntry_name());
                leagueMember.setLeague(league1);
//                leagueMemberRepository.save(leagueMember);
                return leagueMember;
            }).collect(Collectors.toList());
            league1.setLeagueMembers(leagueMembers);
//            leagueRepository.save(league1);
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            return FAILURE;

        }
    }


    public String fillTeamContent(FullInfo fullInfo) {
        LOG.info("Started saving Team content...");
        try {
            List<Teams> teams = fullInfo.getTeams();
            List<Team> teamsVo = teams.stream().map(t -> {
                Team team = new Team();
                team.setId(t.getId());
                team.setName(t.getName());
                team.setShortName(t.getShort_name());
                team.setStrength(t.getStrength());
                return team;
            }).collect(Collectors.toList());
            teamRepository.saveAll(teamsVo);
            LOG.info("Finished saving Team content...");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public String fillPlayerTypes(FullInfo fullInfo) {
        LOG.info("Started saving PlayerType content...");
        try {
            List<Element_types> elementTypes = fullInfo.getElement_types();
            List<PlayerType> collect = elementTypes.stream().map(et -> {
                PlayerType playerType = new PlayerType();
                playerType.setId(et.getId());
                playerType.setPluralName(et.getPlural_name());
                playerType.setPluralShortName(et.getPlural_name_short());
                playerType.setSingularName(et.getSingular_name());
                playerType.setSingularShortName(et.getSingular_name_short());
                playerType.setSquadSelect(et.getSquad_select());
                playerType.setSquadMinPlay(et.getSquad_min_play());
                playerType.setSquadMaxPlay(et.getSquad_max_play());
                return playerType;
            }).collect(Collectors.toList());
            playerTypeRepository.saveAll(collect);
            LOG.info("Finished saving PlayerType content...");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public String fillPlayerContent(FullInfo fullInfo, Map<Long, List<Long>> leagueMemberPlayers) {
        LOG.info("Started saving Player content...");
        try {
            List<Elements> elements = fullInfo.getElements();
            List<Player> playerList = elements.stream().map(pl -> {
                Player player = new Player();
                player.setId(pl.getId());
                player.setCode(pl.getCode());
                player.setFirstName(pl.getFirst_name());
                player.setSecondName(pl.getSecond_name());
                player.setNews(pl.getNews());
                player.setPhoto(formatPhotoFormat(pl.getPhoto()));
                player.setAveragePoints(pl.getPoints_per_game());
                player.setGoalsScored(pl.getGoals_scored());
                player.setAssists(pl.getAssists());
                player.setCleanSheets(pl.getClean_sheets());
                player.setPenaltiesSaved(pl.getPenalties_saved());
                player.setInfluence(pl.getInfluence());
                player.setCreativity(pl.getCreativity());
                player.setThreat(pl.getThreat());
                player.setTotalPoints(pl.getTotal_points());
                player.setElementType(pl.getElement_type());
                player.setTeam(new Team(pl.getTeam()));
//                Long leagueMemberId = getLeagueMemberPlayer(leagueMemberPlayers, pl.getId());
//                if (!leagueMemberId.equals(0l))
//                player.setLeagueMember(new LeagueMember(leagueMemberId));
                player.setPlayerType(new PlayerType(pl.getElement_type()));
                return player;
            }).collect(Collectors.toList());
            playerRepository.saveAll(playerList);
            LOG.info("Finished saving Player content...");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public String fillPlayerHistory() {
        LOG.info("Started saving PlayerHistory content...");
        try {
            List<Player> allPlayers = playerRepository.findAll();
            allPlayers.forEach(player -> {
                Long id = player.getId();
                com.learn.fantasy.dto.player.Player response = premierLeaguApiClient.getPlayerHistoty(id);
                List<History> history = response.getHistory();
                history.forEach(h -> {
                    PlayerHistory playerHistory = new PlayerHistory();
                    playerHistory.setElement(h.getElement());
                    playerHistory.setOpponentTeam(h.getOpponent_team());
                    playerHistory.setTotalPoints(h.getTotal_points());
                    playerHistory.setKickoffTime(h.getKickoff_time());
                    playerHistory.setPlayer(player);
                    playerHistoryRepository.save(playerHistory);
                });
            });
            LOG.info("Finished saving PlayerHistory content...");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public String getLeagueMembers() {
        LOG.info("Started saving League content...");
        try {
            LeagueResponse leagueResponse = premierLeaguApiClient.getLeagueInformation();
            League league = leagueResponse.getLeague();
            com.learn.fantasy.entity.League leagueVO = new com.learn.fantasy.entity.League();
            leagueVO.setId(league.getId());
            leagueVO.setName(league.getName());
            leagueVO.setCreatedDate(league.getCreated());
            List<Results> results = leagueResponse.getStandings().getResults();
            List<LeagueMember> leagueMembers = results.stream().map(r -> {
                LeagueMember leagueMember = new LeagueMember();
                leagueMember.setId(r.getId());
                leagueMember.setEventTotal(r.getEvent_total());
                leagueMember.setPlayerName(r.getPlayer_name());
                leagueMember.setRank(r.getRank());
                leagueMember.setLastRank(r.getLast_rank());
                leagueMember.setRankSort(r.getRank_sort());
                leagueMember.setTotal(r.getTotal());
                leagueMember.setEntry(r.getEntry());
                leagueMember.setEntryName(r.getEntry_name());
                leagueMember.setLeague(leagueVO);
                return leagueMember;
            }).sorted(Comparator.comparingInt(LeagueMember::getRank))
                    .collect(Collectors.toList());
            LOG.info("League Members size is: " + leagueMembers.size());
            leagueVO.setLeagueMembers(leagueMembers);
            leagueRepository.save(leagueVO);
            LOG.info("Finished saving League content...");
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    @Cacheable(value = "fullResponse")
    public FullInfo getFullInfo() {
        LOG.info("Getting Full Information content...");
        return premierLeaguApiClient.getFullInformation();
    }
    private String formatPhotoFormat(String photo){
        return StringUtils.isNotEmpty(photo)?photo.replace("jpg", "png"):photo;
    }
}
