/*
package com.dev.BankService.service;

import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Transaction;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
@SpringBootTest

class TransactionServiceTest {
@Autowired
    TransactionRepository transactionRepository;
@Autowired
        TransactionService transactionService;
@Autowired
    CurrencyRepository currencyRepository;
Transaction transaction;
   String accountId="9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d";
    String accountIdTest="9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d";
    String transactionIdTest="8d569b00-d6e3-11ec-9d64-0242ac120002";
    Currency currency;
    UUID  transactionId=UUID.randomUUID();



    @BeforeEach
    void setUp() {
        transaction=new Transaction(1, UUID.fromString(accountId),transactionId,12,"IN","adding",12);
        transactionRepository.save(transaction);
         currency=new Currency();
        currency.setId(1);
        currency.setName("EUR");
        currency.setBalance(0);
        currency.setAccountId(UUID.fromString(accountIdTest));
        currencyRepository.save(currency);
    }

    @Test
    void postTransaction() {
        Transaction postObj=new Transaction(2, UUID.fromString(accountIdTest),UUID.fromString(transactionIdTest),120,"IN","adding",120);
        Currency currencyAccount=currencyRepository.findByAccountIdAndName(UUID.fromString(accountId),"EUR");
        assertNotNull(currencyAccount);
     Transaction transaction=  transactionService.postTransaction(accountId,140,"EUR","IN","ADDING TO THE ACCOUNT");
     assertEquals(transaction.getAmount(),140);
    }

    @Test
    void getTransactions() {
        List<Transaction> transactions=transactionService.getTransactions(accountId);
        assertNotNull(transactions);

    }
}*/
