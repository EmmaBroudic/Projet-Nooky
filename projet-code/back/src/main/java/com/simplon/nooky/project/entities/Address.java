package com.simplon.nooky.project.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "road")
	private String road;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	public Address() {
	}
	
	public Address(UUID id, String road, String city, int zipCode) {
		this.id = id;
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
	
	public int getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", road=" + road + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
}
