package com.simplon.nooky.project.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_reference")
	private String reference;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "added_at")
	private LocalDateTime addedAt;
	
	@Column(name = "available")
	private boolean available;
	
	public Product() {
	}
	
	public Product(Long id, String reference, String name, String description, String picture, LocalDateTime addedAt, boolean available) {
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.addedAt = addedAt;
		this.available = available;
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", name=" + name + ", picture=" + picture + ", description=" + description + ", addedAt=" + addedAt + ", available=" + available + "]";
	}
}
