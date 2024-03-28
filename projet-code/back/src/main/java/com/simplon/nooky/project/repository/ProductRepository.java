package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByNameContaining(String name);
}
