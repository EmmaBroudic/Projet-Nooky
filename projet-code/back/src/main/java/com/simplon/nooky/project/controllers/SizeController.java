package com.simplon.nooky.project.controllers;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.out.SizeView;
import com.simplon.nooky.project.services.SizeService;


@RestController
@RequestMapping("/sizes")
public class SizeController {
	
	private final SizeService service;
	
	public SizeController(SizeService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public List<SizeView> getAllSizes() {
		return service.getAllSizes();
	}
	
	@GetMapping("/id/{id}")
	public SizeView getSizeById(@PathVariable @NonNull Long id) {
		return service.getSizeById(id);
	}
	
	@GetMapping("label/{label}")
	public SizeView getSizeByLabel(@PathVariable String label) {
		return service.getSizeByLabel(label);
	}
}
