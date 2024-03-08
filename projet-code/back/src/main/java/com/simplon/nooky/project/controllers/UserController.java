package com.simplon.nooky.project.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UUID create(@RequestBody User user) {
		return service.create(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable UUID id) {
		return service.getUserById(id);
	}
}
