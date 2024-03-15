package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.UUID;

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

import com.simplon.nooky.project.entities.Community;
import com.simplon.nooky.project.repository.CommunityRepository;
import com.simplon.nooky.project.services.CommunityService;

@RestController
@RequestMapping("/community")
public class CommunityController {
	private final CommunityService service;
	
	public CommunityController(CommunityService service) {
		this.service = service;
	}
	
	@Autowired
	CommunityRepository communityRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Community> createCommunity(@RequestBody Community community) {
		return service.createCommunity(community);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Collection<Community>> getAllCommunities() {
		return service.getAllCommunities();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Community> getCommunityById(@PathVariable @NonNull UUID id) {
		return service.getCommunityById(id);
	}
}
