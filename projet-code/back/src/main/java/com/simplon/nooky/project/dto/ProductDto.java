package com.simplon.nooky.project.dto;

import java.time.LocalDateTime;

public class ProductDto {
	
	//private Long id;
	private String reference;
	private String name;
	private String description;
	private String picture;
	private LocalDateTime addedAt;
	private boolean available;
	
	public ProductDto() {
	}
	
	public ProductDto(/*Long id,*/ String reference, String name, String description, String picture, LocalDateTime addedAt, boolean available) {
		//this.id = id;
		this.reference = reference;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.addedAt = addedAt;
		this.available = available;
	}
	/*
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}*/
	
	public String getReference() {
		return this.reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
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
    
    public String getPicture() {
    	return this.picture;
    }

    public void setPicture(String picture) {
    	this.picture = picture;
    }
	
	public LocalDateTime getAddedAt() {
		return this.addedAt;
	}
	
	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}
	
	public boolean getAvailable() {
		return this.available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
