package com.simplon.nooky.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.nooky.project.entities.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
	List<Size> findBySizeContaining(String size);
}
