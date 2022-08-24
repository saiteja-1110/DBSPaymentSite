package com.payment.dbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dbs.models.Customer;
import com.payment.dbs.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer getByCustomerId(String id) {
		return customerRepository.findByCustomerId(id);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	
}
