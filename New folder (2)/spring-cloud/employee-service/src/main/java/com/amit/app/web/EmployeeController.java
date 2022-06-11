package com.amit.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.Employee;
import com.amit.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(employeeService.fetchAllEmployee(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}
}
