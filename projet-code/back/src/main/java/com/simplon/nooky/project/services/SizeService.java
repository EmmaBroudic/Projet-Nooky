package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.models.Size;
import com.simplon.nooky.project.repository.SizeRepository;

@Service
public class SizeService {
	
	@Autowired
    private SizeRepository sizeRepository;

	public ResponseEntity<Size> createSize(Size size) {
	    try {
	        Size savedSize = sizeRepository.save(size);

	        return new ResponseEntity<>(savedSize, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

    public ResponseEntity<Size> getSizeById(@NonNull Long id) {
    	try {
    		Optional<Size> sizeData = sizeRepository.findById(id);

    		if (sizeData.isPresent()) {
    			return new ResponseEntity<>(sizeData.get(), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

	public ResponseEntity<Collection<Size>> getAllSizes() {
        try {
            Collection<Size> sizes = sizeRepository.findAll();
            
            if (sizes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sizes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
