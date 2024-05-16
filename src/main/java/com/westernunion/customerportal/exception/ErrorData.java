package com.westernunion.customerportal.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ErrorData {

    private final int status;
    private  final String error;

    private final String message;


    public ErrorData(HttpStatus status, String message){
        this.status=status.value();
        this.error=status.getReasonPhrase();
        this.message=message;
    }

}
