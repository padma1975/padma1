package com.amit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
