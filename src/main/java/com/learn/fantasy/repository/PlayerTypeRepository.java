package com.learn.fantasy.repository;

import com.learn.fantasy.entity.PlayerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface PlayerTypeRepository extends JpaRepository<PlayerType, Long> {
}
