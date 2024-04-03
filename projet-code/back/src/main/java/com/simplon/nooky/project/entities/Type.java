package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class Type extends EntityAbstract {

	@Column(name = "reference")
	private String reference;
	
	@Column(name = "label")
	private String label;
	
	public Type() {
	}
	
	public String getReference() {
  		return this.reference;
    }

    public void setReference(String reference) {
    	this.reference = reference;
    }
    
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
}
