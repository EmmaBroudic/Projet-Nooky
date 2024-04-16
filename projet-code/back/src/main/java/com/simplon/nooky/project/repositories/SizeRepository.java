package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.SizeView;
import com.simplon.nooky.project.entities.Size;

public interface SizeRepository extends JpaRepository<Size,Long> {
	List<Size> findByLabelContaining(String label);
	
	Optional<SizeView> findProjectedById(Long id);
	
	List<SizeView> findAllProjectedBy();
}
