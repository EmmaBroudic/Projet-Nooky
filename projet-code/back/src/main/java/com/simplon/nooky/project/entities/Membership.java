package com.simplon.nooky.project.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Membership {
    private UUID id;
    private String role;
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
}
