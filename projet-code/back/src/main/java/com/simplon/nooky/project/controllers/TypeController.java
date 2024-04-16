package com.simplon.nooky.project.controllers;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.out.TypeView;
import com.simplon.nooky.project.services.TypeService;


@RestController
@RequestMapping("/types")
public class TypeController {
	
	private final TypeService service;
	
	public TypeController(TypeService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public List<TypeView> getAllTypes() {
		return service.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public TypeView getTypeById(@PathVariable @NonNull Long id) {
		return service.getTypeById(id);
	}
}
