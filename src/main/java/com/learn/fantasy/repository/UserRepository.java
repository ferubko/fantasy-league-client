package com.learn.fantasy.repository;

import com.learn.fantasy.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query("select distinct u from UserEntity u where u.email=?1")
    UserEntity findByEmail(String emailKey);
}
