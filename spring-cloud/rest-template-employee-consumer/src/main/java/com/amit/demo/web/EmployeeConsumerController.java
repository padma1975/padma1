package com.amit.demo.web;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amit.demo.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
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
	
	/*
	 * @GetMapping public ResponseEntity<Employee[]> getAllEmployees(){
	 * 
	 * Application instances = discoveryClient.getApplication("employee-service");
	 * 
	 * String host = instances.getInstances().get(0).getHomePageUrl();
	 * 
	 * System.out.println(host);
	 * 
	 * final String uri = "http://EMPLOYEE-SERVICE/employees";
	 * 
	 * ResponseEntity<Employee[]> response = restTemplate.getForEntity(uri,
	 * Employee[].class);
	 * 
	 * ResponseEntity<List<Employee>> response = restTemplate.exchange(uri,
	 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){}); }
	 */
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		/*
		 * Application instances = discoveryClient.getApplication("employee-service");
		 * 
		 * String host = instances.getInstances().get(0).getHomePageUrl();
		 * 
		 * System.out.println(host);
		 */
		
		final String uri = "http://EMPLOYEE-SERVICE/employees";
	 
	    
		ResponseEntity<List<Employee>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){});
		return response.getBody();
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
		final String uri = "http://employee-service/employees/{id}";
	 
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", id);
	     
	    return restTemplate.getForObject(uri, Employee.class, params);

	}

}
