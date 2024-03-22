package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "username")
	private String username;
	
	@Column(name = "picture")
	private String picture;
	
	@Size(max = 40)
	@Column(name = "firstname")
	private String firstname;
	
	@Size(max = 40)
	@Column(name = "lastname")
	private String lastname;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "password")
	private String password;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	public User() {
	}
	
	public User(String email, String username, String picture, String firstname, String lastname, String password, LocalDateTime createdAt) {
	    this.email = email;
		this.username = username;
	    this.picture = picture;
		this.firstname = firstname;
	    this.lastname = lastname;
	    this.password = password;
	    this.createdAt = createdAt;
	}
	
	public UUID getId() {
  		return this.id;
    }

    public void setId(UUID id) {
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", picture=" + picture + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt + "]";
	}
}
