package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.dto.out.AddressView;
import com.simplon.nooky.project.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCityContaining(String city);
	
	Optional<AddressView> findProjectedById(Long id);
}
