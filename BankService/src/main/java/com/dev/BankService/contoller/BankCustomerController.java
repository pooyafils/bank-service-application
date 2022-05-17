package com.dev.BankService.contoller;

import com.dev.BankService.constants.Constants;
import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Customer;
import com.dev.BankService.repository.AllowedCurrenciesRepository;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.CustomerRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/test")

public class BankCustomerController {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    AllowedCurrenciesRepository allowedCurrenciesRepository;
    @Autowired
    CustomerRepository customerRepository;
    @PostMapping
    public ResponseEntity createCoustomer( String customerId,String country,String [] currencies){
        if(customerRepository.findByCustomerId(UUID.fromString(customerId))!=null){
            throw new CustomExceptions("user already exist");
        }
        Customer customer=new Customer();
        List<Currency> currencyList=new ArrayList<>();
        customer.setCustomerId(UUID.fromString(customerId));
        customer.setCountry(country);
        for (String s:currencies){
            if(allowedCurrenciesRepository.findByName(s)==null){
                throw new CustomExceptions("Invalid currency");
            }
            Currency currency=new Currency();
            currency.setAccountId(UUID.randomUUID());
            currency.setCustomer(customer);
            currency.setCustomerId(UUID.fromString(customerId));
            currency.setName(s);
            currency.setBalance(0);
            currencyList.add(currency);
        }
        customer.setCurrencies(currencyList);
        template.convertAndSend(Constants.EXCHANGE_1, Constants.ROUTING_KEY_1,customer);
        return new ResponseEntity(currencyList, HttpStatus.CREATED);
    }
}
