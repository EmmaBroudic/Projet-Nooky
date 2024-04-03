package com.simplon.nooky.project.dto;

import java.time.LocalDateTime;

public class UserDto {
	
	private Long id;
	private String email;
	private String username;
	private String picture;
	private String firstname;
	private String lastname;
	private String password;
	private LocalDateTime createdAt;
	
	public UserDto() {
	}
	
	public UserDto(Long id, String email, String username, String picture, String firstname, String lastname, String password, LocalDateTime createdAt) {
	    this.id = id;
		this.email = email;
		this.username = username;
	    this.picture = picture;
		this.firstname = firstname;
	    this.lastname = lastname;
	    this.password = password;
	    this.createdAt = createdAt;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
