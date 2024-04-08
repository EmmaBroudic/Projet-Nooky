package com.simplon.nooky.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.repositories.ExchangeRepository;

@Service
public class ExchangeService {

	@Autowired
	ExchangeRepository exchangeRepository;
}
