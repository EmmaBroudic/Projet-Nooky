package com.simplon.nooky.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "road")
	private String road;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	public Address() {
	}
	
	public Address(Long id, String road, String city, String zipCode) {
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
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", road=" + road + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
}
