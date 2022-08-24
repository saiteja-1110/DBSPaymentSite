package com.payment.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.dbs.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	Transaction getByTransactionId(Integer id);

}
