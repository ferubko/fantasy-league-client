package com.learn.fantasy.repository;

import com.learn.fantasy.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
