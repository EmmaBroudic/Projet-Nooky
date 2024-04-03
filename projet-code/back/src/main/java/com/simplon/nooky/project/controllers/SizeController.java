package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/all")
	public Collection<Size> getAllSizes() {
		return service.getAllSizes();
	}
	
	@GetMapping("/{id}")
	public Optional<Size> getSizeById(@PathVariable @NonNull int id) {
		return service.getSizeById(id);
	}
}
