package com.simplon.nooky.project.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.creations.CreateUser;
import com.simplon.nooky.project.dto.views.UserView;
import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.repositories.AddressRepository;
import com.simplon.nooky.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private AddressRepository addressRepository;

    public void createUser(CreateUser userCreation) {
    	User user = new User();
        user.setEmail(userCreation.getEmail());
    	user.setUsername(userCreation.getUsername());
    	user.setPicture(userCreation.getPicture());
    	user.setFirstname(userCreation.getFirstname());
    	user.setLastname(userCreation.getLastname());
        user.setPassword(userCreation.getPassword());

        user.setAddress(addressRepository.getReferenceById(userCreation.getAddressId()));
    	
        userRepository.save(user);
        System.out.println(user);
    }

    public UserView getUserById(@NonNull Long id) {
    	return userRepository.findProjectedById(id).get();
    }
    
/*    public UserView getUserByEmail(@NonNull String email) {
    	return userRepository.findProjectedByEmail(email).get();
    }*/

	public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }
}