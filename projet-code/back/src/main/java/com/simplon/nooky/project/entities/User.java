package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
	private UUID id;
	private String username;
	private String picture;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private LocalDateTime createdAt;
	
	public User() {
	}
	
	public UUID getId() {
  		return this.id;
    }

    public void setId(UUID id) {
    	this.id = id;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
