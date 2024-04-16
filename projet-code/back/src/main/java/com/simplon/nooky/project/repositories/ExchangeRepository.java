package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.ExchangeView;
import com.simplon.nooky.project.entities.Exchange;


public interface ExchangeRepository extends JpaRepository<Exchange, Long>{
	List<Exchange> findByIdContaining(Long id);
	
	Optional<ExchangeView> findProjectedById(Long id);
}
