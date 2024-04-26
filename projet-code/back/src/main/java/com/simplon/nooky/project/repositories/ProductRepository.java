package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simplon.nooky.project.dto.out.ProductCardView;
import com.simplon.nooky.project.dto.out.ProductView;
import com.simplon.nooky.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByNameContaining(String name);
	
	Optional<ProductView> findProjectedById(Long id);
	
	List<ProductCardView> findAllProjectedBy();

	/*@Query("""
			select id.p as id from products p
			""")
	@Query(ids = "select id from products", nativeQuery = true)
	List<ProductView> findAllProductsFiltered(List<Long> ids);*/
	
	@Query(value = "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id OR e.product_exchanged_id = p.id\r\n"
			+ "WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProductsFiltered(@Param("p.id") Long id);
	
	List<ProductCardView> findAllProjectedByUserId(Long userId);
	
	/*@Query(value = "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "WHERE p.category_id = :p.category_id \r\n"
			+ "AND p.type_id = :p.type_id \r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProjectedFilteredByCategoryIdAndByTypeId(@Param("p.category_id") Long categoryId,
																		  @Param("p.type_id") Long typeId);*/
	
	@Query(value = "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "WHERE p.category_id = :p.category_id \r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProjectedFilteredByCategoryId(@Param("p.category_id") Long categoryId);
	
	@Query(value = "SELECT p.id, p.name, p.description, p.picture, p.category_id FROM products p\r\n"
			+ "WHERE p.type_id = :p.type_id \r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.description, p.picture, p.category_id FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProjectedFilteredByTypeId(@Param("p.type_id") Long typeId);
}
