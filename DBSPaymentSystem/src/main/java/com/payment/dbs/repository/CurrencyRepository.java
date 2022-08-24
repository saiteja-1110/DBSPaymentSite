package com.payment.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.dbs.models.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String>{

	Currency getByCurrencyCode(String currencyCode);

}
