package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query(value = "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductView> findAllProductsFiltered(@Param("p.id") Long id);
}
