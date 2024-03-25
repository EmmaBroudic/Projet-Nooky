package com.simplon.nooky.project.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return service.createCategory(category);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Collection<Category>> getAllCategories() {
		return service.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable @NonNull Long id) {
		return service.getCategoryById(id);
	}
}
