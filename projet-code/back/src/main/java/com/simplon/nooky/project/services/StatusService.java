package com.simplon.nooky.project.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.views.StatusView;
import com.simplon.nooky.project.entities.Status;
import com.simplon.nooky.project.repositories.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
    public StatusView getStatusById(@NonNull Long id) {
    	return statusRepository.findProjectedById(id).get();
    }
	
	public Collection<Status> getAllStatus() {
		return statusRepository.findAll();
	}
}
