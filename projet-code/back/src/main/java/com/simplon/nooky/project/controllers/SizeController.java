package com.simplon.nooky.project.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Size;
import com.simplon.nooky.project.repository.SizeRepository;
import com.simplon.nooky.project.services.SizeService;


@RestController
@RequestMapping("size")
public class SizeController {
	
	private final SizeService service;
	
	public SizeController(SizeService service) {
		this.service = service;
	}
	
	@Autowired
	SizeRepository sizeRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Size> createSize(@RequestBody Size size) {
		return service.createSize(size);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Collection<Size>> getAllSizes() {
		return service.getAllSizes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Size> getSizeById(@PathVariable @NonNull Long id) {
		return service.getSizeById(id);
	}
}
