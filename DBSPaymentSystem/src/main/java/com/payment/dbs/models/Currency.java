package com.payment.dbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CURRENCY")
public class Currency {
	
	@Id
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name="CURRENCY_NAME")
	private String currencyName;
	
	@Column(name="CONVERSION_RATE")
	private Double  conversionRate;
}
