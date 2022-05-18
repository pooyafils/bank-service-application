package com.dev.BankService.service;

import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Transaction;
import com.dev.BankService.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionServiceTest {
@Autowired
    TransactionRepository transactionRepository;
@Autowired
        TransactionService transactionService;
Transaction transaction;
   String accountId="9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d";
    String accountIdTest="9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d";

    UUID  transactionId=UUID.randomUUID();
    @BeforeEach
    void setUp() {
        transaction=new Transaction(1, UUID.fromString(accountId),transactionId,12,"IN","adding",12);
        transactionRepository.save(transaction);
    }

    @Test
    void postTransaction() {
    }

    @Test
    void getTransactions() {
        List<Transaction> transactions=transactionService.getTransactions(accountId);
        assertEquals(1,transactionService.getTransactions(accountId).size());
    }
}