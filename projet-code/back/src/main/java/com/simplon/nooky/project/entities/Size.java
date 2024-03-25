package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "sizes")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "size_reference")
	private String reference;
	
	@Column(name = "size")
	private String size;
	
	public Size() {
	}
	
	public Size(Long id, String reference, String size) {
		this.id = id;
		this.reference = reference;
		this.size = size;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReference() {
  		return this.reference;
    }

    public void setReference(String reference) {
    	this.reference = reference;
    }
    
    public String getSize() {
    	return this.size;
    }
    
    public void setSize(String size) {
    	this.size = size;
    }
    
	@Override
	public String toString() {
		return "Size [id=" + id + ", reference=" + reference + ", size=" + size + "]";
	}
}
