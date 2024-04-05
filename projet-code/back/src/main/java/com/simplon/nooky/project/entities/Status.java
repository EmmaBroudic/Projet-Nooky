package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status extends EntityAbstract {
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "description")
	private String description;
	
	public Status() {
	}
	
	public String getCode() {
  		return this.code;
    }

    public void setCode(String code) {
    	this.code = code;
    }
    
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
