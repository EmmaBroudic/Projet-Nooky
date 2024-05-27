package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateUser {
	
	@NotNull
	@Email
	@Size(max= 254)
	private String email;
	
	@NotNull
	@Size(max= 50)
	private String username;
	
	@Size(max= 50)
	private String firstname;
	
	@Size(max= 50)
	private String lastname;
	
	@NotNull
	@Size(max= 100)
	private String password;
	
	@NotNull
	@Positive
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
	
	public CreateUser() {
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
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
