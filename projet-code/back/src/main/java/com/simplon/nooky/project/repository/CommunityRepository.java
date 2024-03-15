package com.simplon.nooky.project.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Community;

public interface CommunityRepository extends JpaRepository<Community, UUID> {
	List<Community> findByNameContaining(String name);
}
