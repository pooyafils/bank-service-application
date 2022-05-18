package com.dev.BankService.service;

import com.dev.BankService.model.Currency;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.TransactionRepository;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@DirtiesContext
@SpringBootTest
class BankCustomerServiceTest {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CurrencyRepository currencyRepository;
@Autowired
        BankCustomerService bankCustomerService;
    Currency currency;
    String accountId="29bd810a-d6f0-11ec-9d64-0242ac120002";
    String customerId="80289b74-d6f0-11ec-9d64-0242ac120002";

    @BeforeEach
    void setUp() {
        currency=new Currency();
        currency.setAccountId(UUID.fromString(accountId));
        currency.setName("EUR");
        currency.setBalance(0);
        currency.setId(1);
        currency.setCustomerId(UUID.fromString(customerId));
        currencyRepository.save(currency);
    }

    @Test
    void createCustomer() {
    }

    @ParameterizedTest()
    @ValueSource(strings = "29bd810a-d6f0-11ec-9d64-0242ac120002")
    public void getCustomerAccount(String accountId) {
        Currency currency= new Currency();
        currency=currencyRepository.findByAccountId(UUID.fromString(accountId));
        assertEquals(0,bankCustomerService.getCustomerAccount(accountId).getBalance());
        assertNotNull(bankCustomerService.getCustomerAccount(accountId));

    }
}