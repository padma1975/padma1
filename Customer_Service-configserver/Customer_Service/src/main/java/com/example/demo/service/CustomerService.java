package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomers(String city);
	
	public Customer getCustomerById(Long CustomerId);
	
	public Customer addCustomer(Customer customer);
	
	//public Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException;
	
	public Customer updateCustomerName(Long customerId, String name);
	
	public Customer deleteCustomer(Long customerId);
	
	public String checkStatus(Long customerId);

}
