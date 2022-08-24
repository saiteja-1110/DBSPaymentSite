package com.payment.dbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dbs.models.Customer;
import com.payment.dbs.service.CustomerService;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.findAll();
	}
	
	@GetMapping("/getbyid/{customerId}")
	public Customer getByCustomerId(@PathVariable String customerId) {
		return customerService.getByCustomerId(customerId);
	}
	
	
}
