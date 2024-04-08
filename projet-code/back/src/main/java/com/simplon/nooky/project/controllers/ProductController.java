package com.simplon.nooky.project.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.creations.CreateProduct;
import com.simplon.nooky.project.dto.views.ProductView;
import com.simplon.nooky.project.entities.Product;
import com.simplon.nooky.project.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody CreateProduct product) {
		service.createProduct(product);
	}
	
	@GetMapping("/all")
	public Collection<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductView getProductById(@PathVariable @NonNull Long id) {
		return service.getProductById(id);
	}
}
