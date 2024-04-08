package com.simplon.nooky.project.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.entities.Status;
import com.simplon.nooky.project.services.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
	private final StatusService service;
	
	public StatusController(StatusService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public Collection<Status> getAllStatus() {
		return service.getAllStatus();
	}
	
	@GetMapping("/{id}")
	public Optional<Status> getStatusById(@PathVariable @NonNull Long id) {
		return service.getStatusById(id);
	}
}
