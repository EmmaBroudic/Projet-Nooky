package com.simplon.nooky.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSize {
	
	private Long id;
	private String reference;
	private String size;
	
	public CreateSize() {
	}
	
	public CreateSize(Long id, String reference, String size) {
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
	
	@NotNull
	@Size(max=10)
    public void setReference(String reference) {
    	this.reference = reference;
    }
    
    public String getSize() {
    	return this.size;
    }
    
	@NotNull
	@Size(max=6)
    public void setSize(String size) {
    	this.size = size;
    }
}
