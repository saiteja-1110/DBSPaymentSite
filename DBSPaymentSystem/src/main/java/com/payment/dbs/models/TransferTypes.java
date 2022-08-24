package com.payment.dbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="TRANSFER_TYPES")
@Entity
@Data
public class TransferTypes {
	@Id
	@Column(name="TRANSFER_TYPE_CODE")
	private String transferTypeCode;
	
	@Column(name="TRANSFER_TYPE_DESCRIPTION")
	private String transferTypeDescription;
}
