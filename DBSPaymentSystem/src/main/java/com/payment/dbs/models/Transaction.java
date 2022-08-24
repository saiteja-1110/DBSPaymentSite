package com.payment.dbs.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TRANSACTION")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;
	
	@JoinColumn(name="CUSTOMER_ID")
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Customer customerId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="CURRENCY_CODE")
	private Currency currencyCode;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="SENDER_BIC")
	private Bank senderBIC;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="RECEIVER_BIC")
	private Bank receiverBIC;
	
	@Column(name="RECEIVER_ACC_NUMBER")
	private String receiverAccountHolderNumber;
	
	@Column(name="RECEIVER_ACC_NAME")
	private String receiverAccountHolderName;
	
	@JoinColumn(name="TRANSFER_TYPE")
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TransferTypes transferTypes;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="MESSAGE_CODE")
	private Messages messagecode;
	
	@Column(name="CURRENCY_AMOUNT")
	private Double currencyAmount;
	
	@Column(name="TRANSFER_FEES")
	private Double transferFees;
	
	@Column(name="INR_AMOUNT")
	private Double inrAmount;
	
	@Column(name="TRANSFER_DATE")
	private Date transferDate;
}
