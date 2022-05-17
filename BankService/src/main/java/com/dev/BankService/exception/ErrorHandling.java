package com.dev.BankService.exception;

import java.time.Instant;

public class ErrorHandling {
    private int status;
    private String error;


    public ErrorHandling(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public ErrorHandling() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

