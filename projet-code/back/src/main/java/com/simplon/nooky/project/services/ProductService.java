package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Product;
import com.simplon.nooky.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

    public Optional<Product> getProductById(@NonNull Long id) {
    	return productRepository.findById(id);
    }

	public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
