package com.dev.BankService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private UUID accountId;
    private UUID transactionId;
    private double amount;
    private String directionOfTransaction;
    private String description;
    private double balanceAfterTransaction;

    public Transaction() {
    }

    public Transaction(int id, UUID accountId,
                       double amount, String directionOfTransaction, String description, double balanceAfterTransaction) {
        this.id = id;
        this.accountId = accountId;
        this.transactionId =UUID.randomUUID();
        this.amount = amount;
        this.directionOfTransaction = directionOfTransaction;
        this.description = description;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDirectionOfTransaction() {
        return directionOfTransaction;
    }

    public void setDirectionOfTransaction(String directionOfTransaction) {
        this.directionOfTransaction = directionOfTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }
}
