package com.simplon.nooky.project.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.services.JWTService;

@RestController
public class LoginController {
	
	public JWTService jwtService;
	
	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}

	@CrossOrigin(origins = "http://localhost:5173", methods = RequestMethod.POST)
	@PostMapping("/login")
	public String getToken(Authentication authentication) {
        		String token = jwtService.generateToken(authentication);
        		return token;
	}
}