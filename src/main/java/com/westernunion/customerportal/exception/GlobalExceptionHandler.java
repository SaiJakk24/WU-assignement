package com.westernunion.customerportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorData> handleResource(ResourceNotFoundException ex){
            ErrorData errorData= new ErrorData(HttpStatus.NOT_FOUND, ex.getMessage());
            return  new ResponseEntity<>(errorData,HttpStatus.NOT_FOUND);
    }
}
