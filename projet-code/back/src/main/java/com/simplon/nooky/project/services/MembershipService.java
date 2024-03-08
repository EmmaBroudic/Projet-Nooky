package com.simplon.nooky.project.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplon.nooky.project.database.Database;
import com.simplon.nooky.project.entities.Membership;

@Service
public class MembershipService {
	public UUID create(Membership membership) {
		return Database.addMembership(membership);
	}
	
	public Membership getMembershipById(UUID id) {
		return Database.getMembershipById(id);
	}
}
