package com.dev.BankService.Listener;

import com.dev.BankService.model.Currency;
import com.dev.BankService.model.Customer;
import com.dev.BankService.model.Transaction;
import com.dev.BankService.repository.CurrencyRepository;
import com.dev.BankService.repository.CustomerRepository;
import com.dev.BankService.repository.TransactionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.dev.BankService.constants.Constants.*;

@Component
public class CustomerBankListener {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CurrencyRepository currencyRepository;
@Autowired
    TransactionRepository transactionRepository;
    @RabbitListener(queues = QUEUE_1)
    public void consumeMessageFromQueue(Customer customer) {
        customerRepository.save(customer);
    }


    @RabbitListener(queues = QUEUE_2)
    public void transactions(Transaction transaction) {
        System.out.println("queue  "+transaction.toString());
transactionRepository.save(transaction);
    }


    @RabbitListener(queues = QUEUE_3)
    public void Currency(Currency currency) {
        System.out.println("queue currnecy"  );
Currency update=currencyRepository.findByAccountId(currency.getAccountId());
update.setBalance(currency.getBalance());
        currencyRepository.save(update);
    }
}