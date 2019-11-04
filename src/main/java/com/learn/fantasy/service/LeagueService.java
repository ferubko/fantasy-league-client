package com.learn.fantasy.service;

import com.learn.fantasy.client.PremierLeaguApiClient;
import com.learn.fantasy.dto.Results;
import com.learn.fantasy.dto.leagueMemberContent.MemberContent;
import com.learn.fantasy.dto.legueInfo.League;
import com.learn.fantasy.dto.legueInfo.LeagueResponse;
import com.learn.fantasy.dto.memberPlayers.MemberPlayer;
import com.learn.fantasy.dto.memberPlayers.Picks;
import com.learn.fantasy.vo.LeagueMemberVO;
import com.learn.fantasy.vo.LeagueVO;
import com.learn.fantasy.vo.PlayerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 * Created by stepanferubko
 */
@Service
public class LeagueService {
    private final static Logger LOG = Logger.getLogger(LeagueService.class.getName());

    @Autowired
    private PremierLeaguApiClient premierLeaguApiClient;
    @Autowired
    private PlayersService playersService;

    @Cacheable(value = "leagueMembers")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public LeagueVO getLeagueMembers() {
        LOG.info("Started getting legue members...");

        try {
            LeagueResponse leagueResponse = premierLeaguApiClient.getLeagueInformation();
            League league = leagueResponse.getLeague();
            LeagueVO leagueVO = new LeagueVO();
            leagueVO.setId(league.getId());
            leagueVO.setName(league.getName());
            leagueVO.setCreatedDate(league.getCreated());
            List<Results> results = leagueResponse.getStandings().getResults();
            List<LeagueMemberVO> leagueMembers = results.stream().map(r -> {
                LeagueMemberVO leagueMember = new LeagueMemberVO();
                leagueMember.setId(r.getId());
                leagueMember.setEventTotal(r.getEvent_total());
                leagueMember.setPlayerName(r.getPlayer_name());
                leagueMember.setRank(r.getRank());
                leagueMember.setLastRank(r.getLast_rank());
                leagueMember.setRankSort(r.getRank_sort());
                leagueMember.setTotal(r.getTotal());
                leagueMember.setEntry(r.getEntry());
                leagueMember.setEntry(r.getEntry());
                leagueMember.setEntryName(r.getEntry_name());
                return leagueMember;
            }).sorted(Comparator.comparingInt(LeagueMemberVO::getRank))
                    .collect(Collectors.toList());
            LOG.info("Members size is: " + leagueMembers.size());
            leagueVO.setLeagueMembers(leagueMembers);
            return leagueVO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public LeagueMemberVO getLeagueMemberDetails(Long memberId) {
        LOG.info("Started getting member details...");
        try {
            MemberContent memberPlayer = premierLeaguApiClient.getMemberDetails(memberId);
            LeagueMemberVO leagueMember = new LeagueMemberVO();
            leagueMember.setId(memberPlayer.getId());
            leagueMember.setPlayerName(memberPlayer.getName());
            leagueMember.setCurrentEvent(memberPlayer.getCurrent_event());
            List<Long> playersIds = getPlayersIds(memberId, memberPlayer);
            LOG.info("Found player Ids: " + playersIds.size());
            List<PlayerVO> players = playersService.getPlayersByIds(playersIds);
            LOG.info("Found players: " + players.size());
            leagueMember.setStartingLineup(players);
            LOG.info("Finished getting member content");
            return leagueMember;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

//    @Cacheable(value = "memberPlayers")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Long> getPlayersIds(Long memberId, MemberContent memberPlayer) {
        LOG.info("Started getting player ids...");
        MemberPlayer memberPlayers = premierLeaguApiClient.getMemberPlayerIds(memberId, memberPlayer.getCurrent_event());
        List<Picks> picks = memberPlayers.getPicks();
        return picks.stream().map(Picks::getElement).collect(Collectors.toList());
    }
}