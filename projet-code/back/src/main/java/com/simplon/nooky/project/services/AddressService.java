package com.simplon.nooky.project.services;

import java.util.Collection;
//import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.models.Address;
//import com.simplon.nooky.project.models.Address;
import com.simplon.nooky.project.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepository addressRepository;

	public ResponseEntity<Address> createAddress(Address address) {
	    try {
	        Address savedAddress = addressRepository.save(address);

	        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

    public ResponseEntity<Address> getAddressesById(@NonNull Long id) {
    	try {
    		Optional<Address> addressData = addressRepository.findById(id);

    		if (addressData.isPresent()) {
    			return new ResponseEntity<>(addressData.get(), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

	public ResponseEntity<Collection<Address>> getAllAddresses() {
        try {
            Collection<Address> addresses = addressRepository.findAll();
            
            if (addresses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

/*
 package com.simplon.nooky.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import com.simplon.nooky.project.dto.CreateAddress;
import com.simplon.nooky.project.models.Address;
import com.simplon.nooky.project.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<CreateAddress> createAddress(CreateAddress addressDto) {
        try {
            // Convertir le DTO en entité Address
            Address address = mapToAddress(addressDto);
            // Sauvegarder l'adresse dans la base de données
            Address savedAddress = addressRepository.save(address);
            // Retourner l'adresse sauvegardée sous forme de DTO
            CreateAddress savedAddressDto = mapToCreateAddress(savedAddress);
            return new ResponseEntity<>(savedAddressDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CreateAddress> getAddressById(@NonNull Long id) {
        try {
            // Récupérer l'adresse depuis la base de données
            Address address = addressRepository.findById(id).orElse(null);
            // Vérifier si l'adresse existe
            if (address != null) {
                // Convertir l'entité Address en DTO
                CreateAddress addressDto = mapToCreateAddress(address);
                return new ResponseEntity<>(addressDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Méthode utilitaire pour convertir un DTO en entité Address
    private Address mapToAddress(CreateAddress addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        // Assigner d'autres propriétés si nécessaire
        return address;
    }

    // Méthode utilitaire pour convertir une entité Address en DTO
    private CreateAddress mapToCreateAddress(Address address) {
        CreateAddress addressDto = new CreateAddress();
        addressDto.setCity(address.getCity());
        // Assigner d'autres propriétés si nécessaire
        return addressDto;
    }
}
 * */
