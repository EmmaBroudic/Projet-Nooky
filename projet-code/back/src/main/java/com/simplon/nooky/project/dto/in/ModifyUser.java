package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModifyUser {
	@NotNull
	@Email
	@Size(max= 254)
	private String email;
	
	@NotNull
	@Size(max= 50)
	private String username;
	
	@Size(max= 400)
	private String description;
	
	@Size(max= 1000)
	private String picture;
	
	@Size(max= 50)
	private String firstname;
	
	@Size(max= 50)
	private String lastname;
	
	@NotNull
	private Long addressId;
	
	@NotNull
	@Size(max= 150)
	private String addressRoad;
	
	@NotNull
	@Size(max= 50)
	private String addressCity;
	
	@NotNull
	@Size(max= 5)
	private String addressZipCode;
	
	public ModifyUser() {
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    public String getUsername() {
    	return this.username;
    }

    public void setUsername(String username) {
    	this.username = username;
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
    
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Long getAddressId() {
		return this.addressId;
	}
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public String getAddressRoad() {
		return this.addressRoad;
	}
	
	public void setAddressRoad(String addressRoad) {
		this.addressRoad = addressRoad;
	}
	
	public String getAddressCity() {
		return this.addressCity;
	}
	
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	public String getAddressZipCode() {
		return this.addressZipCode;
	}
	
	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
}
