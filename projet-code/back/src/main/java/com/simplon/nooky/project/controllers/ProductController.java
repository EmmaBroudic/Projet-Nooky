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

import com.simplon.nooky.project.models.Product;
import com.simplon.nooky.project.repository.ProductRepository;
import com.simplon.nooky.project.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@Autowired
	ProductRepository productRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Collection<Product>> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable @NonNull Long id) {
		return service.getProductById(id);
	}
}
