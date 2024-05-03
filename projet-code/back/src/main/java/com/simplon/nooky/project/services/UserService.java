package com.simplon.nooky.project.services;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.in.AuthUser;
import com.simplon.nooky.project.dto.in.CreateUser;
import com.simplon.nooky.project.dto.out.UserView;
import com.simplon.nooky.project.entities.Address;
import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.repositories.AddressRepository;
import com.simplon.nooky.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private AddressRepository addressRepository;
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;

	public void createUser(CreateUser userCreation) {
		User user = new User();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
	    user.setEmail(userCreation.getEmail());
		user.setUsername(userCreation.getUsername());
		user.setDescription(userCreation.getDescription());
		user.setPicture(userCreation.getPicture());
		user.setFirstname(userCreation.getFirstname());
		user.setLastname(userCreation.getLastname());
	    user.setPassword(/*passwordEncoder.encode(*/userCreation.getPassword()/*)*/);
	    user.setCreatedAt(timestamp);
	    
	    Address address = new Address();
	    address = addressRepository.findByRoadAndCityAndZipCode(userCreation.getAddressRoad(), userCreation.getAddressCity(), userCreation.getAddressZipCode());
	    
	   if (address != null) {
		   user.setAddress(addressRepository.findByRoadAndCityAndZipCode(userCreation.getAddressRoad(), userCreation.getAddressCity(), userCreation.getAddressZipCode()));
	   } else {
		    Address addressCreation = new Address();
	   		addressCreation.setRoad(userCreation.getAddressRoad());
	   		addressCreation.setCity(userCreation.getAddressCity());
	   		addressCreation.setZipCode(userCreation.getAddressZipCode());
	   	
	   		addressRepository.save(addressCreation);
	   		user.setAddress(addressRepository.findByRoadAndCityAndZipCode(userCreation.getAddressRoad(), userCreation.getAddressCity(), userCreation.getAddressZipCode()));
	   }

	   userRepository.save(user);
    }

    public UserView getUserById(@NonNull Long id) {
    	return userRepository.findProjectedById(id).get();
    }
    
    public String authenticateUser(@NonNull AuthUser authUser) {
    	Optional<User> user = userRepository.findUserByEmail(authUser.getEmail());
    	
    	String token = "ok";
    	
    	if (user != null) {
    		return token;
    	} else {
    		token = "pas d'utilisateur avec cette adresse mail";
    		
    		return token;
    	}
    }
    
    public UserView getUserByEmail(@NonNull String email) {
    	return userRepository.findProjectedByEmail(email).get();
    }
}    