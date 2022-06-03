package com.amit.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amit.app.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	Map<Long, Product> products = new HashMap<Long, Product>();
	
	@Override
	public Product saveProduct(Product product) {
		products.put(product.getProductId(), product);
		return products.get(product.getProductId());
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		for(Product product: products.values()) {
			productList.add(product);
		}
		return productList;
	}

	@Override
	public Product getProductById(Long productId) {
		return products.get(productId);
	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		if(product.getProductId() !=null) {
			products.put(productId, product);
			return products.get(productId);
		} else {
			Product existingProduct = products.get(productId);
			existingProduct.setProductDesc(product.getProductDesc());
			existingProduct.setProductName(product.getProductName());
			return existingProduct;
		}
		
		
	}

	@Override
	public void deleteProduct(Long productId) {
		products.remove(productId); 
	}

}
