package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.TypeView;
import com.simplon.nooky.project.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
	List<Type> findByLabelContaining(String label);
	
	Optional<TypeView> findProjectedById(Long id);
	
	Optional<TypeView> findProjectedByLabel(String label);
	
	List<TypeView> findAllProjectedBy();
}
