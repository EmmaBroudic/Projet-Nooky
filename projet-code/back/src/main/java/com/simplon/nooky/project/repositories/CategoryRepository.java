package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplon.nooky.project.dto.views.CategoryView;
import com.simplon.nooky.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
		List<Category> findByLabelContaining(String label);
		
		Optional<CategoryView> findProjectedById(Long id);
		
		@Query("SELECT c FROM Category c")
	    List<CategoryView> findAllProjected();
}
