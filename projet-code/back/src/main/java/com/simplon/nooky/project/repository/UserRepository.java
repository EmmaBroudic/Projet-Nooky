package com.simplon.nooky.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		List<User> findByEmailContaining(String email);
		
		Optional<User> findByEmail(String email);
}
