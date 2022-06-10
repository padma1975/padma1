package com.example.demo.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private Long customerId;
	
	private String customerName;
	
	private String email;
	
	private BigInteger mobileNo;
	
	private String city;
	
	private String status;

}
