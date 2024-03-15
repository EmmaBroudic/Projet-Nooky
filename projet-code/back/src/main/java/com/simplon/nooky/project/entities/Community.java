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
@Table(name="community")
public class Community {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "name")
	private String name;
	
	@Column(name = "picture")
	private String picture;
	
	@Size(max = 100)
	@Column(name = "description")
	private String description;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;

	public Community() {
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Community [id=" + id + ", name=" + name + ", picture=" + picture + ", description=" + description + ", createdAt=" + createdAt + "]";
	}
}
