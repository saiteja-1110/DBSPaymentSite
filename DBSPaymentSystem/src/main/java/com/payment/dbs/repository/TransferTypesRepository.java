package com.payment.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.dbs.models.TransferTypes;

@Repository
public interface TransferTypesRepository extends JpaRepository<TransferTypes, String>{

	TransferTypes getByTransferTypeCode(String transferTypes);

}
