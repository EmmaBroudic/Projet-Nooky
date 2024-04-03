package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Type;
import com.simplon.nooky.project.repository.TypeRepository;
import com.simplon.nooky.project.services.TypeService;


@RestController
@RequestMapping("/type")
public class TypeController {
	
	private final TypeService service;
	
	public TypeController(TypeService service) {
		this.service = service;
	}
	
	@Autowired
	TypeRepository typeRepository;
	
	@GetMapping("/all")
	public Collection<Type> getAllTypes() {
		return service.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public Optional<Type> getTypeById(@PathVariable @NonNull int id) {
		return service.getTypeById(id);
	}
}
