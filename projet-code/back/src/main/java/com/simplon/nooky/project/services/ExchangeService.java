package com.simplon.nooky.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.creations.CreateExchange;
import com.simplon.nooky.project.dto.views.ExchangeView;
import com.simplon.nooky.project.entities.Exchange;
import com.simplon.nooky.project.repositories.ExchangeRepository;
import com.simplon.nooky.project.repositories.ProductRepository;
import com.simplon.nooky.project.repositories.StatusRepository;
import com.simplon.nooky.project.repositories.UserRepository;

@Service
public class ExchangeService {
	
	@Autowired
	ExchangeRepository exchangeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	public void createExchange(CreateExchange exchangeCreation) {
		Exchange exchange = new Exchange();
		exchange.setOwner(userRepository.getReferenceById(exchangeCreation.getOwnerId()));
		exchange.setExchanger(userRepository.getReferenceById(exchangeCreation.getExchangerId()));
		exchange.setProductOffered(productRepository.getReferenceById(exchangeCreation.getProductOfferedId()));
		exchange.setProductExchanged(productRepository.getReferenceById(exchangeCreation.getProductExchangedId()));
		exchange.setStatus(statusRepository.getReferenceById(exchangeCreation.getStatusId()));
		
		exchangeRepository.save(exchange);
	}
	
	public Optional<ExchangeView> getExchangesById(Long id) {
		return exchangeRepository.findProjectedById(id);
	}
	
	public void patchExchangesById(CreateExchange exchangePatched) {
		CreateExchange exchange = new CreateExchange();
		// modifier
	}
}
