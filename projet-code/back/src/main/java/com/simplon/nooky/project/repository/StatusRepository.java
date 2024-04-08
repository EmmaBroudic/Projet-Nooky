package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
	List<Status> findByDescriptionContaining(String description);
}
