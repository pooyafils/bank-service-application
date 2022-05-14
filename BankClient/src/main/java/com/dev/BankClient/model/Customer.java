package com.dev.BankClient.model;

import jdk.jfr.Enabled;

import java.util.List;
import java.util.UUID;


public class Customer {
    private int id;
    private UUID customerId;
    private List<Currency> currencies;
    private String country;
}
