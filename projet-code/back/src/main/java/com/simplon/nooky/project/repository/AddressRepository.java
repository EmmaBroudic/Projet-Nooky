package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.simplon.nooky.project.dto.CreateAddress;
import com.simplon.nooky.project.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCityContaining(String city);
	
	//List<CreateAddress> findByCityContaining(String city);
}
