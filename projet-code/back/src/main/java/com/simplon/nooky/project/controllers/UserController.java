package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.repository.UserRepository;
import com.simplon.nooky.project.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/all")
	public Collection<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/id/{id}")
	public Optional<User> getUserById(@PathVariable @NonNull int id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/email/{email}")
	public Optional<User> getUserByEmail(@PathVariable @NonNull String email) {
		return service.getUserByEmail(email);
	}
}
