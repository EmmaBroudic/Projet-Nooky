package com.simplon.nooky.project.controllers;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.views.StatusView;
import com.simplon.nooky.project.services.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
	private final StatusService service;
	
	public StatusController(StatusService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public StatusView getStatusById(@PathVariable @NonNull Long id) {
		return service.getStatusById(id);
	}
}
