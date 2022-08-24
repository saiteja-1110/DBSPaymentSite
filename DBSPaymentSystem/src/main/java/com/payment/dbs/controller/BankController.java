package com.payment.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dbs.models.Bank;
import com.payment.dbs.repository.BankRepository;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {
	@Autowired
	private BankRepository bankRepository;
	
	@GetMapping("/bic/{bIc}")
	public Bank findByBIc(@PathVariable String bIc) {
		return bankRepository.findById(bIc).orElse(null);
	}
}
