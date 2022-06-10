package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping()
	public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam(required = false) String city){
		return new ResponseEntity<>(customerService.getCustomers(city), HttpStatus.OK);
	}
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId, @RequestHeader("first-request") String header){
		System.out.println(header);
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	/*@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.ACCEPTED);
	}*/
	
	@PatchMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomerName(@PathVariable Long customerId, @RequestBody String customerName){
		return new ResponseEntity<>(customerService.updateCustomerName(customerId, customerName), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId){
		return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.ACCEPTED);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_MODIFIED, reason = "Customer is new")
	@GetMapping("/{customerId}/status")
	public String checkCustomerStatus(@PathVariable Long customerId) {
		return customerService.checkStatus(customerId);
	}
}
