package com.payment.dbs.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionDto {
	private Integer transactionId;
	private String customerId;
	private String currencyCode;
	private String senderBIC;
	private String receiverBIC;
	private String receiveAccountHolderNumber;
	private String receiveAccountHolderName;
	private Double currencyAmount;
	private String transferTypes;
	private String messageCode;
	private String instruction;
	private Double inrAmount;
	private Double transferFees;
	private Date transferDate;
	
}
