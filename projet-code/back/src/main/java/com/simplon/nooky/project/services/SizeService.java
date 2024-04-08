package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Size;
import com.simplon.nooky.project.repository.SizeRepository;

@Service
public class SizeService {
	
	@Autowired
    private SizeRepository sizeRepository;

    public Optional<Size> getSizeById(@NonNull Long id) {
    	return sizeRepository.findById(id);
    }

	public Collection<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
}