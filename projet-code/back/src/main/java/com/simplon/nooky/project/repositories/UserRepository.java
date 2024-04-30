package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.in.AuthUser;
import com.simplon.nooky.project.dto.out.UserView;
import com.simplon.nooky.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		List<User> findByEmailContaining(String email);
		
		Optional<UserView> findProjectedById(Long id);
		
		Optional<AuthUser> findProjectedByEmail(String email);
}
