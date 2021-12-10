package com.study.billsControl.billsPaymentAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BillAlreadyRegisteredException extends Exception{

    public BillAlreadyRegisteredException() {
        super("This Bill already registered in the system.");
    }
}