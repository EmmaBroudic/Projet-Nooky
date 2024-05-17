package com.simplon.nooky.project.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.config.SecurityHelper;
import com.simplon.nooky.project.dto.in.AuthUser;
import com.simplon.nooky.project.dto.in.CreateUser;
import com.simplon.nooky.project.dto.in.ModifyUser;
import com.simplon.nooky.project.dto.out.UserEmailView;
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
	
	@Autowired
	private SecurityHelper securityHelper;

	public void createUser(CreateUser userCreation) {
		User user = new User();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
	    user.setEmail(userCreation.getEmail());
		user.setUsername(userCreation.getUsername());
		user.setFirstname(userCreation.getFirstname());
		user.setLastname(userCreation.getLastname());
	    user.setPassword(securityHelper.encode(userCreation.getPassword()));
	    user.setCreatedAt(timestamp);
	    
	    Address address = addressRepository.findByRoadAndCityAndZipCode(userCreation.getAddressRoad(), userCreation.getAddressCity(), userCreation.getAddressZipCode());
	    
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
    	String rawPassword = authUser.getPassword();

    	User user = new User();
    	user = userRepository.findUserByEmail(authUser.getEmail());
    	
    	String encodedPassword = user.getPassword();
    	
    	if (securityHelper.matches(rawPassword, encodedPassword)) {
    		String token = securityHelper.createToken(authUser.getEmail(), user.getId());
    		return token;
    	} else {
    		return "Mauvais mot de passe";
    	}
    }
    
    public UserEmailView getUserByEmail(@NonNull String email) {
    	return userRepository.findProjectedByEmail(email).get();
    }
    
    public void updateUser(Long id, ModifyUser userPatched) {
    	User user = userRepository.findById(id).get();
    	
    	user.setUsername(userPatched.getUsername());
    	user.setEmail(userPatched.getEmail());
    	user.setFirstname(userPatched.getFirstname());
    	user.setLastname(userPatched.getLastname());
    	user.setDescription(userPatched.getDescription());
    	user.setPicture(userPatched.getPicture());

    	Address address = addressRepository.findByRoadAndCityAndZipCode(userPatched.getAddressRoad(), userPatched.getAddressCity(), userPatched.getAddressZipCode());
	    
 	    if (address != null) {
 		   user.setAddress(addressRepository.findByRoadAndCityAndZipCode(userPatched.getAddressRoad(), userPatched.getAddressCity(), userPatched.getAddressZipCode()));
 	    } else {
 		    Address addressCreation = new Address();
 	   		addressCreation.setRoad(userPatched.getAddressRoad());
 	   		addressCreation.setCity(userPatched.getAddressCity());
 	   		addressCreation.setZipCode(userPatched.getAddressZipCode());
 	   	
 	   		addressRepository.save(addressCreation);
 	   		user.setAddress(addressRepository.findByRoadAndCityAndZipCode(userPatched.getAddressRoad(), userPatched.getAddressCity(), userPatched.getAddressZipCode()));
 	    }
    	
    	userRepository.save(user);
    }
}    