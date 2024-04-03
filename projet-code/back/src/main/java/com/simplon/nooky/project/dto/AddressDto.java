package com.simplon.nooky.project.dto;

public class AddressDto {
	private String road;
	private String city;
	private String zipCode;
	
	public AddressDto() {
	}
	
	public AddressDto(String road, String city, String zipCode) {
		this.road = road;
		this.city = city;
		this.zipCode = zipCode;
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
