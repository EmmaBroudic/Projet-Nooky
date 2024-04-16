 package com.simplon.nooky.project.controllers;

import java.util.List;

//import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.out.CategoryView;
import com.simplon.nooky.project.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	
	@GetMapping("/all")
	public List<CategoryView> getAllCategories() {
		return service.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public CategoryView getCategoryById(@PathVariable Long id) {
		return service.getCategoryById(id);
	}
}
