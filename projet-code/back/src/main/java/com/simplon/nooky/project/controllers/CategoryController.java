 package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Category;
import com.simplon.nooky.project.repository.CategoryRepository;
import com.simplon.nooky.project.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/all")
	public Collection<Category> getAllCategories() {
		return service.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable @NonNull int id) {
		return service.getCategoryById(id);
	}
}
