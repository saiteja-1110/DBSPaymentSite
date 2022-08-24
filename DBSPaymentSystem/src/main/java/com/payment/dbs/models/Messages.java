package com.payment.dbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MESSAGE")
@Data
public class Messages {
	@Id
	@Column(name="MESSAGE_CODE")
	private String messageCode;
	
	@Column(name="INSTRUCTION")
	private String instruction;
}
