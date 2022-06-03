package com.amit.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping("/{msg}")
	public String sayHello(@PathVariable String msg, @RequestParam(defaultValue = "Amit") String name) {
		return "Hello "+name+", "+msg;
	}
	
}
