package com.amit.jpa.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.jpa.example.model.User;
import com.amit.jpa.example.repository.UserRepository;
import com.amit.jpa.examplee.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable(value = "id") Long userId,
			@RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		/*
		 * user.setEmailAddress(userDetails.getEmailAddress());
		 * user.setLastname(userDetails.getLastname());
		 * user.setFirstname(userDetails.getFirstname());
		 * user.setAge(userDetails.getAge());
		 */
		final User updatedUser = userRepository.save(userDetails);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/users/email/{emailId}")
	public User findUserByEmailId(@PathVariable String emailId){
		return userRepository.findByEmailAddress(emailId);
	}
	
	@GetMapping("/users/lastName/{lastName}")
	public List<User> findUserByLastName(@PathVariable String lastName){
		return userRepository.findByLastname(lastName);
	}
	
	@GetMapping("/users/age/{age}")
	public List<User> findUserByAge(@PathVariable Integer age){
		return userRepository.findByAge(age);
	}
	
	@GetMapping("/users/countAge/{age}")
	public Integer countUserByage(@PathVariable Integer age){
		return userRepository.countByAge(age);
	}

}
