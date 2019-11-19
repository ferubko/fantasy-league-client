package com.learn.fantasy.repository;

import com.learn.fantasy.entity.PlayerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by stepanferubko
 */
@Repository
public interface PlayerHistoryRepository extends CrudRepository<PlayerHistory, Long> {

    @Query("select h from PlayerHistory h where h.player.id=?1")
    List<PlayerHistory> findByPlayerId(Long playerId);
}
