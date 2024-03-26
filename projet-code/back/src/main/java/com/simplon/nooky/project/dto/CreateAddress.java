package com.simplon.nooky.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAddress {
	
	private Long id;
	private String road;
	private String city;
	private String zipCode;
	
	public CreateAddress() {
	}
	
	public CreateAddress(Long id, String road, String city, String zipCode) {
		this.id = id;
		this.road = road;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoad() {
		return this.road;
	}
	
	@NotNull
	@Size(max=100)
	public void setRoad(String road) {
		this.road = road;
	}
	
	public String getCity() {
		return this.city;
	}
	
	@NotNull
	@Size(max=100)
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	@NotNull
	@Size(max=5)
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
