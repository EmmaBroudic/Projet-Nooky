package com.simplon.nooky.project.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Category;
import com.simplon.nooky.project.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UUID create(@RequestBody Category category) {
		return service.create(category);
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable UUID id) {
		return service.getCategoryById(id);
	}
}
