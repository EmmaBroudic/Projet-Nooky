package com.simplon.nooky.project.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.views.TypeView;
import com.simplon.nooky.project.entities.Type;
import com.simplon.nooky.project.repositories.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
    private TypeRepository typeRepository;

    public TypeView getTypeById(@NonNull Long id) {
    	return typeRepository.findProjectedById(id).get();
    }

	public Collection<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
