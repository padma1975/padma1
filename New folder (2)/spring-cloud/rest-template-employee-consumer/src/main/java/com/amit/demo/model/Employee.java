package com.amit.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer employeeId;
	
	private String employeeName;
	
	private String emailId;
	
	private Double salary;

}
