package com.simplon.nooky.project.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product extends EntityAbstract {
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "added_at")
	private Timestamp addedAt;
	
	@Column(name = "wishlist")
	private String wishlist;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	Size size;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	Type type;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	public Product() {
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
	
	public Timestamp getAddedAt() {
		return this.addedAt;
	}
	
	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}
	
	public String getWishlist() {
		return this.wishlist;
	}
	
	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}
	
	public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}