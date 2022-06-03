package com.amit.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Spring Security JPA Demo Application";
	}
	
	@GetMapping("/user/welcome")
	public String greetUser() {
		return "Welcome User to my application: Spring Security JPA Demo";
	}
	
	@GetMapping("/admin/welcome")
	public String greetAdmin() {
		return "Welcome Admin user to my application: Spring Security JPA Demo";
	}

}
