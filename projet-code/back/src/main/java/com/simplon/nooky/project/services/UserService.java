package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.CreateUser;
import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.repository.AddressRepository;
import com.simplon.nooky.project.repository.UserRepository;

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

    public Optional<User> getUserById(@NonNull Long id) {
    	return userRepository.findById(id);
    }
    
    public Optional<User> getUserByEmail(@NonNull String email) {
    	return userRepository.findByEmail(email);
    }

	public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }
}