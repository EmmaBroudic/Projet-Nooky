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

import com.simplon.nooky.project.entities.Membership;
import com.simplon.nooky.project.services.MembershipService;

@RestController
@RequestMapping("/membership")
public class MembershipController {
	private final MembershipService service;
	
	public MembershipController(MembershipService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UUID create(@RequestBody Membership membership) {
		return service.create(membership);
	}
	
	@GetMapping("/{id}")
	public Membership getMembershipById(@PathVariable UUID id) {
		return service.getMembershipById(id);
	}

}
