package com.flock.test.flocktest.dao;

import com.flock.test.flocktest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
