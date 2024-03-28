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

import com.simplon.nooky.project.models.Type;
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Type> createType(@RequestBody Type type) {
		return service.createType(type);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Collection<Type>> getAllTypes() {
		return service.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable @NonNull Long id) {
		return service.getTypeById(id);
	}
}
