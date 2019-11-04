package com.learn.fantasy.repository;

import com.learn.fantasy.entity.LeagueMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface LeagueMemberRepository extends JpaRepository<LeagueMember, Long> {
}
