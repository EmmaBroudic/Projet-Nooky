package com.simplon.nooky.project.services;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.out.CategoryView;
import com.simplon.nooky.project.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public CategoryView getCategoryById(Long id) {
		return categoryRepository.findProjectedById(id).get();
    }
    
    public CategoryView getCategoryByLabel(String label) {
		return categoryRepository.findProjectedByLabel(label).get();
    }
    
    public List<CategoryView> getAllCategories() {
        return categoryRepository.findAllProjectedBy();
    }
}
