package com.dev.BankService.contoller;

import com.dev.BankService.constants.Constants;
import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Customer;
import com.dev.BankService.repository.AllowedCurrenciesRepository;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.CustomerRepository;
import com.dev.BankService.service.BankCustomerService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bankCustomer")

public class BankCustomerController {
@Autowired
    BankCustomerService bankCustomerService;
    @PostMapping
    public ResponseEntity createCustomer( String customerId,String country,String [] currencies){
 List<Currency> currenciesList=bankCustomerService.createCustomer(customerId,country,currencies);
        return new ResponseEntity(currenciesList, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getCustomerAccount(@RequestParam String AccountId){
        Currency currency=bankCustomerService.getCustomerAccount(AccountId);
        return new ResponseEntity(currency,HttpStatus.OK);
    }
}
