package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Category {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    
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
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
