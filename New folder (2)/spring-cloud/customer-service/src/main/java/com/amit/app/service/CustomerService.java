package com.amit.app.service;

import java.util.List;

import com.amit.app.model.Customer;
import com.amit.app.util.CustomerNotFoundException;

public interface CustomerService {
	
	public List<Customer> getCustomers(String city);
	
	public Customer getCustomerById(Long CustomerId);
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException;
	
	public Customer updateCustomerName(Long customerId, String name);
	
	public Customer deleteCustomer(Long customerId);
	
	public String checkStatus(Long customerId);

}
