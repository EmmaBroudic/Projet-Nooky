package com.simplon.nooky.project.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplon.nooky.project.database.Database;
import com.simplon.nooky.project.entities.Product;

@Service
public class ProductService {
	public UUID create(Product product) {
		return Database.addProduct(product);
	}
	
	public Product getProductById(UUID id) {
		return Database.getProductById(id);
	}
}
