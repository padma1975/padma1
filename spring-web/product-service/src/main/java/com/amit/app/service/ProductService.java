package com.amit.app.service;

import java.util.List;

import com.amit.app.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId);

	public Product updateProduct(Long productId, Product product);

	public void deleteProduct(Long productId);

}
