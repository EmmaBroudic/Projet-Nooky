package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.simplon.nooky.project.dto.views.ProductView;
import com.simplon.nooky.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByNameContaining(String name);
	
	Optional<ProductView> findProjectedById(Long id);
	
	List<ProductView> findAllProjectedBy();
	
	/*@Query("""
			select p.name as name, p.description as description, 
			u.username as userUsername  from Product p where p.id in (:ids)
			""")
	List<ProductView> findAllProductsFiltered(List<Long> ids);*/
}
