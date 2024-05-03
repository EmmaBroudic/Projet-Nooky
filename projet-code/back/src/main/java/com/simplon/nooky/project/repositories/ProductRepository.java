package com.simplon.nooky.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simplon.nooky.project.dto.out.ProductCardView;
import com.simplon.nooky.project.dto.out.ProductView;
import com.simplon.nooky.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByNameContaining(String name);
	
	Optional<Product> findById(Long id);
	
	Optional<ProductView> findProjectedById(Long id);
	
	List<ProductCardView> findAllProjectedBy();
	
	@Query("SELECT p.id AS id, p.name AS name, p.description AS description, p.picture AS picture, p.category.id AS categoryId, p.type.id AS typeId, p.size.id AS sizeId " +
		       "FROM Product p " +
		       "WHERE p.id NOT IN (" +
		       "    SELECT p.id FROM Product p " +
		       "    INNER JOIN Exchange e ON e.productOffered.id = p.id OR e.productExchanged.id = p.id " +
		       "    INNER JOIN e.statusProdOffered s " +
		       "    WHERE s.description NOT IN ('Proposition échange refusée', 'Echange annulé') " +
		       ")")
	List<ProductCardView> findAllProductsFiltered(@Param("productId") Long productId);
	
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
	
	@Query(value = "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "WHERE p.category_id = :p.category_id \r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProjectedFilteredByCategoryId(@Param("p.category_id") Long categoryId);
	
	
	@Query(value = "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "WHERE p.type_id = :p.type_id \r\n"
			+ "EXCEPT\r\n"
			+ "SELECT p.id, p.name, p.description, p.picture FROM products p\r\n"
			+ "INNER JOIN exchanges e ON e.product_offered_id = p.id\r\n"
			+ "	OR e.product_exchanged_id = p.id\r\n"
			+ "	WHERE e.status_id != 3 AND e.status_id != 4", nativeQuery = true)
	List<ProductCardView> findAllProjectedFilteredByTypeId(@Param("p.type_id") Long typeId);
}
