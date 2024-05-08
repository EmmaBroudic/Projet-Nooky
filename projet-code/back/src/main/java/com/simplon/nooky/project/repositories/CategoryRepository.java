package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.CategoryView;
import com.simplon.nooky.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
		List<Category> findByLabelContaining(String label);
		
		Optional<CategoryView> findProjectedById(Long id);
		
		Optional<CategoryView> findProjectedByLabel(String label);
		
	    List<CategoryView> findAllProjectedBy();
}
