package com.payment.dbs.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dbs.dto.TransactionDto;
import com.payment.dbs.models.Customer;
import com.payment.dbs.models.Transaction;
import com.payment.dbs.repository.TransactionRepository;
import com.payment.dbs.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("/alltransactions")
	public List<TransactionDto> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/search/{name}")
	public boolean searchInList(@PathVariable String name) throws FileNotFoundException {
		return transactionService.searchList(name);
	}
	
	@GetMapping("/getbyid/{transactionId}")
	public TransactionDto getByTransactionId(@PathVariable Integer transactionId) {
		return transactionService.getByTransactionId(transactionId);
	}
	
	@PostMapping("/posttransaction")
	public Transaction addTransaction(@RequestBody TransactionDto transactionDto) {
		Transaction transaction =  transactionService.addTransaction(transactionDto);
		return transactionRepository.save(transaction) ;
	}
}
