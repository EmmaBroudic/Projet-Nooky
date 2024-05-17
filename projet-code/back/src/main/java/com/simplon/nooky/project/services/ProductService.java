package com.simplon.nooky.project.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.in.CreateProduct;
import com.simplon.nooky.project.dto.in.ModifyProduct;
import com.simplon.nooky.project.dto.out.ProductCardView;
import com.simplon.nooky.project.dto.out.ProductView;
import com.simplon.nooky.project.entities.Product;
import com.simplon.nooky.project.repositories.CategoryRepository;
import com.simplon.nooky.project.repositories.ProductRepository;
import com.simplon.nooky.project.repositories.SizeRepository;
import com.simplon.nooky.project.repositories.TypeRepository;
import com.simplon.nooky.project.repositories.UserRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void createProduct(CreateProduct productCreation) {
		
		Product product = new Product();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String productRef = "PROD" + String.valueOf(timestamp);
		
		product.setName(productCreation.getName());
		product.setReference(productRef);
		product.setDescription(productCreation.getDescription());
		product.setPicture(productCreation.getPicture());
		product.setWishlist(productCreation.getWishlist());
		product.setAddedAt(timestamp);
        
        product.setCategory(categoryRepository.getReferenceById(productCreation.getCategoryId()));
        product.setSize(sizeRepository.getReferenceById(productCreation.getSizeId()));
        product.setType(typeRepository.getReferenceById(productCreation.getTypeId()));
        product.setUser(userRepository.getReferenceById(productCreation.getUserId()));
        
		productRepository.save(product);
	}

    public ProductView getProductById(Long id) {
    	return productRepository.findProjectedById(id).get();
    }

    public List<ProductCardView> getAllProducts(Long id) {
       return productRepository.findAllProductsFiltered(id);
    }
    
    public List<ProductCardView> getAllProductsFromUser(Long userId) {
    	return productRepository.findAllProjectedByUserId(userId);
    }
    
   public void updateProduct(Long id, ModifyProduct productPatched) {
    	Product product = productRepository.findById(id).get();
    	
    	product.setName(productPatched.getName());
    	product.setDescription(productPatched.getDescription());
    	product.setPicture(productPatched.getPicture());
    	product.setWishlist(productPatched.getWishlist());
    	product.setCategory(categoryRepository.getReferenceById(productPatched.getCategoryId()));
        product.setSize(sizeRepository.getReferenceById(productPatched.getSizeId()));
        product.setType(typeRepository.getReferenceById(productPatched.getTypeId()));
    	
    	productRepository.save(product);
    }
    
    public void deleteProductById(Long id) {
    	productRepository.deleteById(id);    	
    }
}
