package com.dev.BankService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Enabled;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private UUID customerId;
    private String country;
    @OneToMany(mappedBy ="customer", cascade=CascadeType.ALL,fetch = FetchType.EAGER )
    private List<Currency> currencies;
    public Customer() {
    }

    public Customer(int id, UUID customerId, String country, List<Currency> currencies) {
        this.id = id;
        this.customerId = customerId;
        this.country = country;
        this.currencies = currencies;
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


}
