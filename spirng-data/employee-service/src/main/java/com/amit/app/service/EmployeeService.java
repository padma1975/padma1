package com.amit.app.service;

import java.util.List;

import com.amit.app.model.Employee;

public interface EmployeeService {
	
	public List<Employee> fetchAllEmployee();
	
	public Employee addEmployee(Employee employee);

}
