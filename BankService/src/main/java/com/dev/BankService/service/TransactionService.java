package com.dev.BankService.service;

import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Transaction;
import com.dev.BankService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
@Autowired
    CurrencyRepository currencyRepository;
@Autowired
    CustomerRepository customerRepository;
@Autowired
    AllowedCurrenciesRepository allowedCurrenciesRepository;
@Autowired
    DirectionOfTransactionRepository directionOfTransactionRepository;
@Autowired
    TransactionRepository transactionRepository;

    public void postTransaction(String accountId, double amount, String currency, String directionOfTransaction, String description) {
        if (currencyRepository.findByAccountId(UUID.fromString(accountId)) == null) {
            throw new CustomExceptions("account missing");
        }
        if (allowedCurrenciesRepository.findByName(currency) == null) {
            throw new CustomExceptions("Invalid currency");
        }
        if (amount <= 0) {
            throw new CustomExceptions("Invalid amount");
        }
        if (directionOfTransactionRepository.findByDirection(directionOfTransaction) == null) {
            throw new CustomExceptions("Invalid direction");

        }
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID());
        transaction.setAccountId(UUID.fromString(accountId));
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setDirectionOfTransaction(directionOfTransaction);
        System.out.println(transaction.toString());
        Currency currencyAccount=currencyRepository.findByAccountIdAndName(UUID.fromString(accountId),currency);
        System.out.println(directionOfTransaction);
        if(directionOfTransaction.equals("IN")){

            currencyAccount.setBalance(currencyAccount.getBalance()+amount);
        }
       if(directionOfTransaction.equals("OUT")){
           if(currencyAccount.getBalance()-amount<0){
               throw new CustomExceptions("Insufficient funds");
           }
           else
           currencyAccount.setBalance(currencyAccount.getBalance()-amount);

       }
       System.out.println(currencyAccount.getBalance());
       currencyRepository.save(currencyAccount);
       transaction.setBalanceAfterTransaction(currencyAccount.getBalance());
        transactionRepository.save(transaction);

    }
}
