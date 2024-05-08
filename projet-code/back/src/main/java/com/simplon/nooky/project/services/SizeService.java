package com.simplon.nooky.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.out.SizeView;
import com.simplon.nooky.project.repositories.SizeRepository;

@Service
public class SizeService {
	
	@Autowired
    private SizeRepository sizeRepository;

    public SizeView getSizeById(@NonNull Long id) {
    	return sizeRepository.findProjectedById(id).get();
    }
    
    public SizeView getSizeByLabel(@NonNull String label) {
    	return sizeRepository.findProjectedByLabel(label).get();
    }

	public List<SizeView> getAllSizes() {
        return sizeRepository.findAllProjectedBy();
    }
}