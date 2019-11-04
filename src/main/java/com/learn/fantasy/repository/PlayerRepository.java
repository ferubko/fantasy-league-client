package com.learn.fantasy.repository;

import com.learn.fantasy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by stepanferubko
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where (p.team.id=?1  or ?1 is null) and (p.elementType=?2 or ?2 is null)")
    List<Player> findByTeamIdAndPlayerType(Long teamId, Long playerType);

    @Query("select p from Player p where p.id in :ids")
    List<Player> findByIdIn(@Param("ids") List<Long> ids);
}
