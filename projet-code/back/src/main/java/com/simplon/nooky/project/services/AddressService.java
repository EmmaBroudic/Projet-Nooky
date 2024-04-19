package com.simplon.nooky.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.out.AddressView;
import com.simplon.nooky.project.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepository addressRepository;

    public AddressView getAddressesById(Long id) {
    	return addressRepository.findProjectedById(id).get();
    }
}
