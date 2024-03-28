package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.models.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
	List<Type> findByTypeContaining(String type);
}
