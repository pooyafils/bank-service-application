package com.dev.BankService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public  class  GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorHandling> productException (CustomExceptions customExceptions) {
        ErrorHandling errorHandling = new ErrorHandling();
        errorHandling.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorHandling.setError(customExceptions.getMessage());
        //errorHandling.setTimestames(System.currentTimeMillis());
        return new ResponseEntity<>(errorHandling, HttpStatus.BAD_REQUEST);
    }
}
