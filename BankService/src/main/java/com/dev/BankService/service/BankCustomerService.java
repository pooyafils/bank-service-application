package com.dev.BankService.service;

import com.dev.BankService.constants.Constants;
import com.dev.BankService.exception.CustomExceptions;
import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Customer;
import com.dev.BankService.repository.AllowedCurrenciesRepository;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.CustomerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BankCustomerService {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    AllowedCurrenciesRepository allowedCurrenciesRepository;
    @Autowired
    CustomerRepository customerRepository;
    public List<Currency> createCustomer( String customerId,String country,String [] currencies){
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
        return currencyList;
    }
    public Currency getCustomerAccount( String AccountId){
if(currencyRepository.findByAccountId(UUID.fromString(AccountId))==null){
    throw new  CustomExceptions("Account not found");
}
        return currencyRepository.findByAccountId(UUID.fromString(AccountId));
    }
}
