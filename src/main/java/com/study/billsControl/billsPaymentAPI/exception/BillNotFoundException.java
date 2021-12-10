package com.study.billsControl.billsPaymentAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillNotFoundException extends Exception{

    public BillNotFoundException() {
        super("This bill was not found.");
    }
}
