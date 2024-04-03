package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "sizes")
public class Size extends EntityAbstract {

	@Column(name = "reference")
	private String reference;
	
	@Column(name = "description")
	private String description;
	
	public Size() {
	}
	
	public String getReference() {
  		return this.reference;
    }

    public void setReference(String reference) {
    	this.reference = reference;
    }
    
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
