package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.models.Category;
import com.simplon.nooky.project.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

	public ResponseEntity<Category> createCategory(Category category) {
	    try {
	        Category savedCategory = categoryRepository.save(category);

	        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

    public ResponseEntity<Category> getCategoryById(@NonNull Long id) {
    	try {
    		Optional<Category> categoryData = categoryRepository.findById(id);

    		if (categoryData.isPresent()) {
    			return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

	public ResponseEntity<Collection<Category>> getAllCategories() {
        try {
            Collection<Category> categories = categoryRepository.findAll();
            
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
