package com.amit.app.model;

import lombok.Data;

@Data
public class Product {
	
	private Long productId;
	
	private String productName;
	
	private String productDesc;
	
	private Double price;
	
	private Integer quantity;

}
