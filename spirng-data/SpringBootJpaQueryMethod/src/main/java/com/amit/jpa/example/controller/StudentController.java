package com.amit.jpa.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.jpa.example.model.Student;
import com.amit.jpa.example.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping
    public List<Student> allStudent() {
        return (List<Student>) studentRepository.findAll();
    }
	
	@GetMapping("/{studentId}")
    public Student findByStudentId(@PathVariable int studentId) {
        return studentRepository.findById(studentId).get();
    }
	
	@GetMapping("/age/{ageNo}")
	public List<Student> findByAge(@PathVariable int ageNo) {
		return studentRepository.findByAge(ageNo);
	}
	
	@PostMapping
	public HttpStatus saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return HttpStatus.CREATED;
	}

}
