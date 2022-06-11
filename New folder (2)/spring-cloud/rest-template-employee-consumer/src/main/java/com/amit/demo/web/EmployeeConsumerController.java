package com.amit.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amit.demo.model.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/template/employees")
public class EmployeeConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient discoveryClient;
	
	@GetMapping
	public ResponseEntity<Employee[]> getAllEmployees(){
		
		
		final String uri = "http://localhost:8088/employees";
	 
	    ResponseEntity<Employee[]> response = restTemplate.getForEntity(uri, Employee[].class);
	    return response;
	}
	
	//Get result into the List
	
	/*
	 * @GetMapping("/all") public List<Employee> getEmployees(){ final String uri =
	 * "http://localhost:8088/employees";
	 * 
	 * ResponseEmployeeBO response = restTemplate.getForObject(uri,
	 * ResponseEmployeeBO.class); return response.getEmployees(); }
	 */
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id){
		final String uri = "http://localhost:8088/employees/{id}";
	 
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", id);
	     
	    return restTemplate.getForObject(uri, Employee.class, params);

	}

}
