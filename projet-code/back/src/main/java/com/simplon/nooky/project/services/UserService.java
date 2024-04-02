package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.User;
import com.simplon.nooky.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
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