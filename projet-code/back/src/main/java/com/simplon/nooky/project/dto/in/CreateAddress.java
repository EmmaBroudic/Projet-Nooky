package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAddress {
	
	@NotNull
	@Size(max= 150)
	private String road;
	
	@NotNull
	@Size(max= 50)
	private String city;
	
	@NotNull
	@Size(min= 5, max= 5)
	private String zipCode;
	
	public CreateAddress() {
	}
	
	public String getRoad() {
		return this.road;
	}
	
	public void setRoad(String road) {
		this.road = road;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
