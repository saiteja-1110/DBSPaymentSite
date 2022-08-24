package com.payment.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.dbs.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String>{
	Bank findBybIc(String BIC);
	
}
