package com.amit.jpa.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.jpa.example.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public List<Student> findByName(String name);
	
	@Query("select s from Student s where s.age = ?1")
	List<Student> findByAge(Integer age);

}
