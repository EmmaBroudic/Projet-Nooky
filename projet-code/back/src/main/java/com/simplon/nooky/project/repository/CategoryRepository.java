package com.simplon.nooky.project.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
		List<Category> findByNameContaining(String name);
}
