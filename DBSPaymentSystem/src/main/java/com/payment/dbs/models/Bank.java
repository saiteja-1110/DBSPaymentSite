package com.payment.dbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="BANK")
public class Bank {
	@Id
	@Column(name="BIC")
	private String bIc;
	
	@Column(name="BANK_NAME")
	private String bankName;
}
