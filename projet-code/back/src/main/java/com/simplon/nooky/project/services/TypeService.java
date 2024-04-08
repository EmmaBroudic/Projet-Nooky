package com.simplon.nooky.project.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.entities.Type;
import com.simplon.nooky.project.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
    private TypeRepository typeRepository;

    public Optional<Type> getTypeById(@NonNull Long id) {
    	return typeRepository.findById(id);
    }

	public Collection<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
