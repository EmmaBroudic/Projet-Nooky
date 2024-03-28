package com.simplon.nooky.project.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.models.User;
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
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/all")
	public ResponseEntity<Collection<User>> getAllUsers() {
		return service.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable @NonNull Long id) {
		return service.getUserById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable @NonNull String email) {
		return service.getUserByEmail(email);
	}
}
