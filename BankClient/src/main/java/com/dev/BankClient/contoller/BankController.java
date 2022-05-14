package com.dev.BankClient.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    public ResponseEntity registerCustomer(@RequestParam String customerId,@RequestParam String country,@RequestParam String currencies){

        return new ResponseEntity("customer account has been created",HttpStatus.OK);
    }
}
