package com.amit.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer employeeId;
	
	private String employeeName;
	
	private String emailId;
	
	private Double salary;

}
