package com.simplon.nooky.project.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "sizes")
public class Size {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "size")
	private String size;
	
	public Size() {
	}
	
	public Size(UUID id, String size) {
		this.id = id;
		this.size = size;
	}
	
	public UUID getId() {
  		return this.id;
    }

    public void setId(UUID id) {
    	this.id = id;
    }
    
    public String getSize() {
    	return this.size;
    }
    
    public void setSize(String size) {
    	this.size = size;
    }
    
	@Override
	public String toString() {
		return "Size [id=" + id + ", size=" + size + "]";
	}
}
