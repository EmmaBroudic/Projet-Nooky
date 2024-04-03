package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Category;
import com.simplon.nooky.project.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(@NonNull int id) {
		return categoryRepository.findById(id);
    }

	public Collection<Category> getAllCategories() {
        return categoryRepository.findAll();
	}
}
