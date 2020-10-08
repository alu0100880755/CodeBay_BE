package com.init.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.users.entities.User;

public interface UsersDAO extends JpaRepository<User, Long> {

}
