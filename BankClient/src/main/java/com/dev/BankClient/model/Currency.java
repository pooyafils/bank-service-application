package com.dev.BankClient.model;

import java.util.List;
import java.util.UUID;

public class Currency {
    private int id;
    private UUID accountId;
    private UUID customerId;
    private double balance;
    private String name;
    public Currency() {
    }

    public Currency(int id, UUID accountId, UUID customerId, double balance, String name) {
        this.id = id;
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.name = name;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
