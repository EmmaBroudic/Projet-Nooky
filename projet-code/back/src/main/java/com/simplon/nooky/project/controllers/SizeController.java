package com.simplon.nooky.project.controllers;

import java.util.Collection;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.views.SizeView;
import com.simplon.nooky.project.entities.Size;
import com.simplon.nooky.project.services.SizeService;


@RestController
@RequestMapping("/sizes")
public class SizeController {
	
	private final SizeService service;
	
	public SizeController(SizeService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public Collection<Size> getAllSizes() {
		return service.getAllSizes();
	}
	
	@GetMapping("/{id}")
	public SizeView getSizeById(@PathVariable @NonNull Long id) {
		return service.getSizeById(id);
	}
}
