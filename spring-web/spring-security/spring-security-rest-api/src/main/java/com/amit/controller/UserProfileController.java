package com.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amit.jpa.Customer;
import com.amit.service.CustomerService;

@RestController
//@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public Customer getUserDetail(@PathVariable Long id){
        return customerService.findById(id);
    }
}
