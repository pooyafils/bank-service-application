package com.dev.BankService.contoller;

import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Transaction;
import com.dev.BankService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class BankTransactionController {
@Autowired
    TransactionService transactionService;
    @PostMapping
    public ResponseEntity postTransaction(@RequestParam String accountId,@RequestParam double amount,
                                          @RequestParam String currency,@RequestParam String directionOfTransaction,
                                        @RequestParam String description){

    Transaction transaction = transactionService.postTransaction(accountId,amount,currency,directionOfTransaction,description);
        return new ResponseEntity(transaction, HttpStatus.CREATED);
    }
}
