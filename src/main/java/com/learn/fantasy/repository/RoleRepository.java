package com.learn.fantasy.repository;

import com.learn.fantasy.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stepanferubko
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("select distinct r from Role r where r.role=?1")
    Role findByRole(String roleName);
}
