package com.dev.BankService.Listener;

import com.dev.BankService.model.Customer;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.CustomerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.dev.BankService.constants.Constants.QUEUE_2;

@Component
public class CustomerBankListener {
    public static final String QUEUE_1 = "bankQueue";
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    @RabbitListener(queues = QUEUE_1)
    public void consumeMessageFromQueue(Customer customer) {
        customerRepository.save(customer);
    }


    @RabbitListener(queues = QUEUE_2)
    public void cons(Customer customer) {
System.out.println(customer.getId());
    }
}