package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
	private UUID id;
	private String name;
	private String picture;
	private String description;
	private String transaction;
	private LocalDateTime createdAt;
	
	public Product() {
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
	
    public String getPicture() {
    	return this.picture;
    }

    public void setPicture(String picture) {
    	this.picture = picture;
    }
    
    public String getDescription() {
    	return this.description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
    
    public String getTransaction() {
    	return this.transaction;
    }

    public void setTransaction(String transaction) {
    	this.transaction = transaction;
    }
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
