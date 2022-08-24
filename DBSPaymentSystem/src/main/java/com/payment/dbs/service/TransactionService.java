package com.payment.dbs.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dbs.dto.TransactionDto;
import com.payment.dbs.models.Bank;
import com.payment.dbs.models.Currency;
import com.payment.dbs.models.Customer;
import com.payment.dbs.models.Transaction;
import com.payment.dbs.models.TransferTypes;
import com.payment.dbs.models.Messages;
import com.payment.dbs.repository.BankRepository;
import com.payment.dbs.repository.CurrencyRepository;
import com.payment.dbs.repository.CustomerRepository;
import com.payment.dbs.repository.MessageRepository;
import com.payment.dbs.repository.TransactionRepository;
import com.payment.dbs.repository.TransferTypesRepository;

@Service
public class TransactionService {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TransferTypesRepository transferTypesRepository;
	
	public Transaction addTransaction(TransactionDto transactionDto) {
		return TransactionDtotoEntity(transactionDto);
	}
	
	public TransactionDto getByTransactionId(Integer id) {
		Transaction transaction = transactionRepository.getByTransactionId(id);
		return TransactionEntitytoDto(transaction);
	}


	private Transaction TransactionDtotoEntity(TransactionDto transactionDto) {
		Transaction transactions = new Transaction();
		
		Customer customer = customerRepository.findByCustomerId(transactionDto.getCustomerId());
		Currency currency = currencyRepository.getByCurrencyCode(transactionDto.getCurrencyCode());
		Bank senderbank = bankRepository.findBybIc(transactionDto.getSenderBIC());
		Bank receiverbank = bankRepository.findBybIc(transactionDto.getReceiverBIC());
		TransferTypes transferTypeCode = transferTypesRepository.getByTransferTypeCode(transactionDto.getTransferTypes());
		Messages messageCode = messageRepository.getByMessageCode(transactionDto.getMessageCode());
		deductAmount(customer,transactionDto.getInrAmount(),customer.getClearBalance() ,transactionDto.getTransferFees());
		transactions.setTransactionId(transactionDto.getTransactionId());
		transactions.setCustomerId(customer);
		transactions.setCurrencyCode(currency);
		transactions.setSenderBIC(senderbank);
		transactions.setReceiverBIC(receiverbank);
		transactions.setTransferTypes(transferTypeCode);
		transactions.setMessagecode(messageCode);
		transactions.setReceiverAccountHolderNumber(transactionDto.getReceiveAccountHolderNumber());
		transactions.setReceiverAccountHolderName(transactionDto.getReceiveAccountHolderName());
		transactions.setTransferFees(transactionDto.getTransferFees());
		transactions.setInrAmount(transactionDto.getInrAmount());
		transactions.setTransferDate(transactionDto.getTransferDate());
		transactions.setCurrencyAmount(0.0);
		return transactions;
	}
	
	private void deductAmount(Customer customer, double inrAmount, double clearBalance, double transferFees) {
		double newAmount = clearBalance-inrAmount-transferFees;
		customer.setClearBalance(newAmount);
		customerRepository.save(customer);
		
	}
	
	public boolean searchList(String name) throws FileNotFoundException{
		InputStream inputStream = new FileInputStream("C:/Users/Administrator/Downloads/sdnlist.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		Stream<String> lineStream = bufferedReader.lines();
		List<String> ans = lineStream.filter(a -> a.toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
		return (ans.size()==0);
	}
	
	private TransactionDto TransactionEntitytoDto(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
//		Transaction transaction = transactionRepository.getByTransactionId(id);
		String customerid = transaction.getCustomerId().getCustomerId();
		String currencycode = transaction.getCurrencyCode().getCurrencyCode();
		String senderBIC = transaction.getSenderBIC().getBIc();
		String receiverBIC = transaction.getReceiverBIC().getBIc();
		String transfertypecode = transaction.getTransferTypes().getTransferTypeCode();
		String messagecode = transaction.getMessagecode().getMessageCode();
		transactionDto.setTransactionId(transaction.getTransactionId());
		transactionDto.setCustomerId(customerid);
		transactionDto.setCurrencyCode(currencycode);
		transactionDto.setSenderBIC(senderBIC);
		transactionDto.setReceiverBIC(receiverBIC);
		transactionDto.setTransferTypes(transfertypecode);
		transactionDto.setMessageCode(messagecode);
		transactionDto.setReceiveAccountHolderNumber(transaction.getReceiverAccountHolderNumber());
		transactionDto.setReceiveAccountHolderName(transaction.getReceiverAccountHolderName());
		transactionDto.setCurrencyAmount(transaction.getCurrencyAmount());
		transactionDto.setTransferFees(transaction.getTransferFees());
		transactionDto.setTransferDate(transaction.getTransferDate());
		transactionDto.setInrAmount(transaction.getInrAmount());
		return transactionDto;
	}
	public List<TransactionDto> getAllTransactions(){
        return transactionRepository.findAll()
                .stream()
                .map(this::TransactionEntitytoDto)
                .collect(Collectors.toList());    
    }

	
}
