package com.simplon.nooky.project.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@Column(name = "id")
    private UUID id;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "name")
    private String name;
	
	@Size(max = 100)
	@Column(name = "description")
    private String description;
    
    public Category() {
    }
    
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public String getDescription() {
    	return this.description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description  + "]";
	}
}
