package com.simplon.nooky.project.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplon.nooky.project.database.Database;
import com.simplon.nooky.project.entities.Category;

@Service
public class CategoryService {
	public UUID create(Category category) {
		return Database.addCategory(category);
	}
	
	public Category getCategoryById(UUID id) {
		return Database.getCategoryById(id);
	}
}
