package com.amit.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseEmployeeBO {
	
	private List<Employee> employees;
	
	public ResponseEmployeeBO() {
		employees = new ArrayList<>();
	}

}
