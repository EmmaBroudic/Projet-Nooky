package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.simplon.nooky.project.dto.views.ProductView;
import com.simplon.nooky.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByNameContaining(String name);
	
	Optional<ProductView> findProjectedById(Long id);
	
	List<ProductView> findAllProjectedBy();

	/*@Query("""
			select id.p as id from products p
			""")
	@Query(ids = "select id from products", nativeQuery = true)
	List<ProductView> findAllProductsFiltered(List<Long> ids);*/
	
	@Query("select * from products")
	List<Product> findAllProductsFiltered();
}
