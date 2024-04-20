package com.simplon.nooky.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.in.CreateProduct;
import com.simplon.nooky.project.dto.out.ProductCardView;
import com.simplon.nooky.project.dto.out.ProductView;
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
	public List<ProductCardView> getAllProducts(Long id) {
		return service.getAllProducts(id);
	}
	
	@GetMapping("/{id}")
	public ProductView getProductById(@PathVariable @NonNull Long id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/all/user/{userId}")
	public List<ProductCardView> getAllProductsFromUser(@PathVariable @NonNull Long userId) {
		return service.getAllProductsFromUser(userId);
	}
	
	@GetMapping("/all/filtered/{categoryId}/{typeId}")
	public List<ProductCardView> getAllProductsByCategoryAndType(@PathVariable Long categoryId, @PathVariable Long typeId) {
		return service.getAllProductsByCategoryAndType(categoryId, typeId);
	}
}
