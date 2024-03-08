package com.simplon.nooky.project.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplon.nooky.project.database.Database;
import com.simplon.nooky.project.entities.Community;

@Service
public class CommunityService {
	public UUID create(Community community) {
		return Database.addCommunity(community);
	}
	
	public Community getCommunityById(UUID id) {
		return Database.getCommunityById(id);
	}
}
