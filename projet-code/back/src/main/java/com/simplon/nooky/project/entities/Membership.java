package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="membership")
public class Membership {
	
	@Id
	@Column(name = "id")
    private UUID id;
	
	@NotBlank
	@Column(name = "role")
    private String role;
	
	@Column(name = "createdAt")
    private LocalDateTime createdAt;
    
    public Membership() {
    }
    
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Membership [id=" + id + ", role=" + role + ", createdAt=" + createdAt + "]";
	}
}
