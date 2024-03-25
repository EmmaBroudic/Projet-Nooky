package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		List<User> findByUsernameContaining(String username);
}
