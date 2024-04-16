package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.StatusView;
import com.simplon.nooky.project.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
	List<Status> findByDescriptionContaining(String description);
	
	Optional<StatusView> findProjectedById(Long id);
}
