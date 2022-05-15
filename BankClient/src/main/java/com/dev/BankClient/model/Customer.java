package com.dev.BankClient.model;

import jdk.jfr.Enabled;

import java.util.List;
import java.util.UUID;


public class Customer {
    private int id;
    private UUID customerId;
    private List<Currency> currencies;
    private String country;

    public Customer() {
    }

    public Customer(int id, UUID customerId, List<Currency> currencies, String country) {
        this.id = id;
        this.customerId = customerId;
        this.currencies = currencies;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", currencies=" + currencies +
                ", country='" + country + '\'' +
                '}';
    }
}
