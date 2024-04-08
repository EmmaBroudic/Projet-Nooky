package com.simplon.nooky.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends EntityAbstract {
	
	@Column(name = "road")
	private String road;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	/*@OneToMany(
			mappedBy = "address",
			cascade = CascadeType.ALL, 
			orphanRemoval = true, 
			fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private List<User> users = new ArrayList<>();*/
	
	public Address() {
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
