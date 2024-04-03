package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
	List<Type> findByLabelContaining(String label);
}
