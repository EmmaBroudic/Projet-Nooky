package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByNameContaining(String name);
}
