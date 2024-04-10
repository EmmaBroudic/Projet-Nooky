package com.simplon.nooky.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.nooky.project.dto.creations.CreateProduct;
import com.simplon.nooky.project.dto.views.ProductView;
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
		
		product.setName(productCreation.getName());
		
		// changer ligne ci-dessous -> création d'une référence
		product.setReference(productCreation.getReference());

		product.setDescription(productCreation.getDescription());
		product.setPicture(productCreation.getPicture());
		product.setWishlist(productCreation.getWishlist());
        
        product.setCategory(categoryRepository.getReferenceById(productCreation.getCategoryId()));
        product.setSize(sizeRepository.getReferenceById(productCreation.getSizeId()));
        product.setType(typeRepository.getReferenceById(productCreation.getTypeId()));
        product.setUser(userRepository.getReferenceById(productCreation.getUserId()));
        
		productRepository.save(product);
		System.out.println(product);
	}

    public ProductView getProductById(Long id) {
    	//GetProductDto productDto = new GetProductDto();
    	
    	// notfound code http
    	// Product product = productRepository.findById(id).orElse(null);;
//
//		if (product != null) {
//			productDto.setName(product.getName());
//			productDto.setDescription(product.getDescription());
//			productDto.setPicture(product.getPicture());
//			productDto.setWishlist(product.getWishlist());
//		}
    	
    	//Optional.ofNullable(productDto);
    	
    	return productRepository.findProjectedById(id).get();
    }

	public List<ProductView> getAllProducts() {
        return productRepository.findAllProjectedBy();
    }
}
