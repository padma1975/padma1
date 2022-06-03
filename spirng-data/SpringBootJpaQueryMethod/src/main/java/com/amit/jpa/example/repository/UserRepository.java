package com.amit.jpa.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.jpa.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAddress(String emailAddress);

	List<User> findByLastname(String lastname);
	
	List<User> findByAge(Integer age);
	
	Integer countByAge(Integer age);
}
