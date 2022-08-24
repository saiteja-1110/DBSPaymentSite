package com.payment.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.dbs.models.Messages;

@Repository
public interface MessageRepository extends JpaRepository<Messages, String> {

	Messages getByMessageCode(String messageCode);

}
