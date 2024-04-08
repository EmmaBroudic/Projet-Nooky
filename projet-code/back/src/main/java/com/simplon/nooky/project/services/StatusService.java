package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Status;
import com.simplon.nooky.project.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
    public Optional<Status> getStatusById(@NonNull Long id) {
    	return statusRepository.findById(id);
    }
	
	public Collection<Status> getAllStatus() {
		return statusRepository.findAll();
	}
}
