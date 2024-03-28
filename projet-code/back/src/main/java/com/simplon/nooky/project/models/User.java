package com.simplon.nooky.project.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	public User() {
	}
	
	public User(Long id, String email, String username, String picture, String firstname, String lastname, String password, LocalDateTime createdAt) {
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", picture=" + picture + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt + "]";
	}
}
