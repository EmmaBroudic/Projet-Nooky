package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Type;
import com.simplon.nooky.project.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
    private TypeRepository typeRepository;

    public ResponseEntity<Type> createType(Type type) {
        try {
            Type savedType = typeRepository.save(type);

            return new ResponseEntity<>(savedType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Type> getTypeById(@NonNull Long id) {
    	try {
    		Optional<Type> typeData = typeRepository.findById(id);

    		if (typeData.isPresent()) {
    			return new ResponseEntity<>(typeData.get(), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

	public ResponseEntity<Collection<Type>> getAllTypes() {
        try {
            Collection<Type> types = typeRepository.findAll();
            
            if (types.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(types, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
