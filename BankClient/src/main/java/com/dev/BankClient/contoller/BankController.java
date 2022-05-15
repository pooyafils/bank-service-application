package com.dev.BankClient.contoller;

import com.dev.BankClient.constants.Constants;
import com.dev.BankClient.model.Currency;
import com.dev.BankClient.model.Customer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
    @Autowired
    private RabbitTemplate template;
    @PostMapping
    public ResponseEntity registerCustomer(@RequestParam String customerId,@RequestParam String country,@RequestParam String[] currencies){
        Customer customer=new Customer();
        customer.setCountry(country);
        customer.setCustomerId(UUID.fromString(customerId));
       List<Currency> currencyList=new ArrayList();
       for(String str:currencies){
           Currency currency=new Currency();
           currency.setName(str);
           currencyList.add(currency);

       }
customer.setCurrencies(currencyList);
       System.out.println(customer);
//template.convertAndSend(Constants.EXCHANGE_1, Constants.ROUTING_KEY_1,customer);
        return new ResponseEntity("customer account has been created",HttpStatus.OK);
    }
}
