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

import com.simplon.nooky.project.entities.Product;
import com.simplon.nooky.project.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UUID create(@RequestBody Product product) {
		return service.create(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable UUID id) {
		return service.getProductById(id);
	}
}
