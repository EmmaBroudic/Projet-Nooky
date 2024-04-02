package com.simplon.nooky.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Address;
import com.simplon.nooky.project.repository.AddressRepository;
import com.simplon.nooky.project.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	private final AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}
	
	@Autowired
	AddressRepository addressRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Address createAddress(@RequestBody Address address) {
		return service.createAddress(address);
	}
	
	@GetMapping("/{id}")
	public Optional<Address> getAddressesById(@PathVariable @NonNull Long id) {
		return service.getAddressesById(id);
	}
}
