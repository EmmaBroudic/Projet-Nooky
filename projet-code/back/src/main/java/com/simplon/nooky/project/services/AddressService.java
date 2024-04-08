package com.simplon.nooky.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.AddressView;
import com.simplon.nooky.project.dto.CreateAddress;
import com.simplon.nooky.project.entities.Address;
import com.simplon.nooky.project.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepository addressRepository;

	public void createAddress(CreateAddress addressCreation) {
		Address address = new Address();
		address.setRoad(addressCreation.getRoad());
		address.setCity(addressCreation.getCity());
		address.setZipCode(addressCreation.getZipCode());
	    
		addressRepository.save(address);
	    System.out.println(address);
	}

    public AddressView getAddressesById(Long id) {
    	return addressRepository.findProjectedById(id).get();
    }
}
