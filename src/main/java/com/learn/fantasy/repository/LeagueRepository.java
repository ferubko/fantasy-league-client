package com.learn.fantasy.repository;

import com.learn.fantasy.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}
