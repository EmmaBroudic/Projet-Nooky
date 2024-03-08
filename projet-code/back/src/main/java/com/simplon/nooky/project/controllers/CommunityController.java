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

import com.simplon.nooky.project.entities.Community;
import com.simplon.nooky.project.services.CommunityService;

@RestController
@RequestMapping("/community")
public class CommunityController {
	private final CommunityService service;
	
	public CommunityController(CommunityService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UUID create(@RequestBody Community community) {
		return service.create(community);
	}
	
	@GetMapping("/{id}")
	public Community getCommunityById(@PathVariable UUID id) {
		return service.getCommunityById(id);
	}
}
