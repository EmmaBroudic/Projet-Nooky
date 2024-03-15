package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Community;
import com.simplon.nooky.project.repository.CommunityRepository;

@Service
public class CommunityService {
	@Autowired
    private CommunityRepository communityRepository;

    public ResponseEntity<Community> createCommunity(Community community) {
        try {
            UUID newCommunityId = UUID.randomUUID();
            community.setId(newCommunityId);
            Community savedCommunity = communityRepository.save(community);

            return new ResponseEntity<>(savedCommunity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Community> getCommunityById(@NonNull UUID id) {
    	try {
    		Optional<Community> communityData = communityRepository.findById(id);

    		if (communityData.isPresent()) {
    			return new ResponseEntity<>(communityData.get(), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

	public ResponseEntity<Collection<Community>> getAllCommunities() {
        try {
            Collection<Community> communities = communityRepository.findAll();
            
            if (communities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(communities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
