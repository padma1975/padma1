package com.amit.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.Product;
import com.amit.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId){
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@PutMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(productId, product), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("{productId}")
	public ResponseEntity<Product> updateProductNameAndDesc(@PathVariable Long productId, @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(productId, product), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product is successfully deleted having productId:"+productId, HttpStatus.ACCEPTED);
	}

}
