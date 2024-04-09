package com.simplon.nooky.project.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.nooky.project.dto.creations.CreateExchange;
import com.simplon.nooky.project.dto.views.ExchangeView;
import com.simplon.nooky.project.services.ExchangeService;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {
	private final ExchangeService service;
	
	public ExchangeController(ExchangeService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createExchange(@RequestBody CreateExchange exchange) {
		service.createExchange(exchange);
	}
	
	@GetMapping("/{id}")
	public Optional<ExchangeView> getExchangesById(@PathVariable @NonNull Long id) {
		return service.getExchangesById(id);
	}
	
	@PatchMapping("/{id}")
	public void patchtExchangesById(@PathVariable @NonNull Long id) {
		return patchExchangesById(id);
	}
}
