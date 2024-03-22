package com.simplon.nooky.project.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class Type {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "type")
	private String type;
	
	public Type() {
	}
	
	public Type(UUID id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public UUID getId() {
  		return this.id;
    }

    public void setId(UUID id) {
    	this.id = id;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}
}
