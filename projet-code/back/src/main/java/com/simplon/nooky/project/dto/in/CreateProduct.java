package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProduct {
	
	@NotNull
	@Size(max= 50)
	private String name;
	
	@NotNull
	@Size(max= 20)
	private String reference;
	
	@Size(max= 400)
	private String description;
	
	@Size(max= 1000)
	private String picture;
	
	@Size(max= 200)
	private String wishlist;
	
	private Long categoryId;
	
	private Long sizeId;
	
	private Long typeId;
	
	private Long userId;
	
	public CreateProduct() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getReference() {
		return this.reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
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
	
	public String getWishlist() {
		return this.wishlist;
	}
	
	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}
	
	public Long getCategoryId() {
		return this.categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getSizeId() {
		return this.sizeId;
	}
	
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}
	
	public Long getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
