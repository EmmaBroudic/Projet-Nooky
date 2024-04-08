package com.simplon.nooky.project.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.views.SizeView;
import com.simplon.nooky.project.entities.Size;
import com.simplon.nooky.project.repositories.SizeRepository;

@Service
public class SizeService {
	
	@Autowired
    private SizeRepository sizeRepository;

    public SizeView getSizeById(@NonNull Long id) {
    	return sizeRepository.findProjectedById(id).get();
    }

	public Collection<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
}