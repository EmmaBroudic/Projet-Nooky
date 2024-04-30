package com.simplon.nooky.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.in.CreateExchange;
import com.simplon.nooky.project.dto.out.ExchangeView;
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
		exchange.setStatusProdOffered(statusRepository.getReferenceById(exchangeCreation.getStatusProdOfferedId()));
		exchange.setStatusProdExchanged(statusRepository.getReferenceById(exchangeCreation.getStatusProdOfferedId()));
		
		exchangeRepository.save(exchange);
	}
	
	public ExchangeView getExchangesById(Long id) {
		return exchangeRepository.findProjectedById(id).get();
	}
	
	public void updateExchange(Long id, CreateExchange exchangePatched) {

		Exchange exchange = exchangeRepository.findById(id).get();

		exchange.setStatusProdOffered(statusRepository.getReferenceById(exchangePatched.getStatusProdOfferedId()));
		exchange.setStatusProdExchanged(statusRepository.getReferenceById(exchangePatched.getStatusProdExchangedId()));
		
		exchangeRepository.save(exchange);
	}
}
