package com.simplon.nooky.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Address;
import com.simplon.nooky.project.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepository addressRepository;

	public Address createAddress(Address address) {
	    return addressRepository.save(address);
	}

    public Optional<Address> getAddressesById(@NonNull Long id) {
    	return addressRepository.findById(id);
    }
}
