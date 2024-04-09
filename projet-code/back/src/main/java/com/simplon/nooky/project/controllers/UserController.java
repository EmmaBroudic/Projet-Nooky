package com.simplon.nooky.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.creations.CreateUser;
import com.simplon.nooky.project.dto.views.UserView;
import com.simplon.nooky.project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody CreateUser user) {
		service.createUser(user);
	}
	
	@GetMapping("/id/{id}")
	public UserView getUserById(@PathVariable @NonNull Long id) {
		return service.getUserById(id);
	}
	/*
	@GetMapping("/email/{email}")
	public UserView getUserByEmail(@PathVariable @NonNull String email) {
		return service.getUserByEmail(email);
	}*/
}
