package com.simplon.nooky.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateType {
	
	private Long id;
	private String reference;
	private String type;
	
	public CreateType() {
	}
	
	public CreateType(Long id, String reference, String type) {
		this.id = id;
		this.reference = reference;
		this.type = type;
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
    
    public String getType() {
    	return this.type;
    }
    
	@NotNull
	@Size(max=100)
    public void setType(String type) {
    	this.type = type;
    }
}
