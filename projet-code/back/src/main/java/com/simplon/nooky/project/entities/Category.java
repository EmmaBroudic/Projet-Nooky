package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "category_reference")
    private String reference;
	
	@Column(name = "category")
    private String category;
	
	@Column(name = "description")
    private String description;
    
    public Category() {
    }
    
    public Category(Long id, String reference, String category, String description) {
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
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
    
    public String getDescription() {
    	return this.description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", reference=" + reference + ", category=" + category + ", description=" + description  + "]";
	}
}
