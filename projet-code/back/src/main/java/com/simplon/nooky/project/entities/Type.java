package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "type_reference")
	private String reference;
	
	@Column(name = "type")
	private String type;
	
	public Type() {
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
    
    public String getType() {
    	return this.type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
	@Override
	public String toString() {
		return "Type [id=" + id + ", reference=" + reference + ", type=" + type + "]";
	}
}
