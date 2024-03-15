package com.simplon.nooky.project.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
		List<User> findByUsernameContaining(String username);
}
