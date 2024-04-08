package com.simplon.nooky.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.CategoryView;
import com.simplon.nooky.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
		List<Category> findByLabelContaining(String label);
		
		//List<CategoryView> findAllProjected();
		
		Optional<CategoryView> findProjectedById(Long id);
}
