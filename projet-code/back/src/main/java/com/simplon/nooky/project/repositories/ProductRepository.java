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
	
}
