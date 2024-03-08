package com.simplon.nooky.project.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplon.nooky.project.database.Database;
import com.simplon.nooky.project.entities.User;

@Service
public class UserService {
	public UUID create(User user) {
		return Database.addUser(user);
	}
	
	public User getUserById(UUID id) {
		return Database.getUserById(id);
	}
}
