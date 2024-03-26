package com.simplon.nooky.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCategory {
	
	private Long id;
	private String reference;
	private String category;
	private String description;

    public CreateCategory() {
    }
    
    public CreateCategory(Long id, String reference, String category, String description) {
    	this.id = id;
    	this.reference = reference;
    	this.category = category;
    	this.description = description;
    }
    
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
    
	public String getReference() {
		return this.reference;
	}
	
	@NotNull
	@Size(max=10)
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	@NotNull
	@Size(max=100)
	public void setCategory(String category) {
		this.category = category;
	}
    
    public String getDescription() {
    	return this.description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
}
