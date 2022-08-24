package com.payment.dbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CUSTOMER")
@Data
public class Customer {
	@Id
	@Column(name="CUSTOMER_ID", length=14)
	private String customerId;
	
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	
	@Column(name="OVER_DRAFT_FLAG", columnDefinition = "TINYINT(1)")
	private boolean overDraftFlag;
	
	@Column(name="CLEAR_BALANCE")
	private Double clearBalance;
	@Column(name="CUSTOMER_ADDRESS", length=100)
	private String customerAddress;
	@Column(name="CUSTOMER_CITY", length=100)
	private String customerCity;
	@Column(name="CUSTOMER_TYPE")
	private String customerType;
}
