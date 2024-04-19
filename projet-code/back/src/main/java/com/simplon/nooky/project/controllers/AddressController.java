package com.simplon.nooky.project.controllers;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.out.AddressView;
import com.simplon.nooky.project.services.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	private final AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public AddressView getAddressesById(@PathVariable @NonNull Long id) {
		return service.getAddressesById(id);
	}
}
