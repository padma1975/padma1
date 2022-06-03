package com.amit.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amit.app.model.Customer;
import com.amit.app.util.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	Map<Long, Customer> customers = new HashMap<>();

	@Override
	public List<Customer> getCustomers(String city) {
		List<Customer> customerList = new ArrayList<>();
			for(Customer customer: customers.values()) {
				if(null == city || city.isBlank() || city.isEmpty()) {
					customerList.add(customer);
				} else if(customer.getCity().equals(city)) {
						customerList.add(customer);
				}
			}
		return customerList;
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customers.get(customerId);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
		return customers.get(customer.getCustomerId());
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException {
		if(null == getCustomerById(customerId)) {
			throw new CustomerNotFoundException("Customer is not available to our system having id: "+customerId);
		}
		customers.put(customerId, customer);
		return customers.get(customerId);
	}

	@Override
	public Customer updateCustomerName(Long customerId, String name) {
		Customer customer = customers.get(customerId);
		customer.setCustomerName(name);
		customers.put(customerId, customer);
		return customers.get(customerId);
	}

	@Override
	public Customer deleteCustomer(Long customerId) {
		return customers.remove(customerId);
	}
	
	@Override
	public String checkStatus(Long customerId) {
		Customer customer = customers.get(customerId);
		return customer.getStatus();
	}

}
