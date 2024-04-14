package com.sogebank.accountmanagerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(ObjectExistsDuplicationException.class)
    public ResponseEntity<StandardError> objectExistsDuplicationException(ObjectExistsDuplicationException e){
        StandardError err = new StandardError(e.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(ObjectSearchNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectSearchNotFoundException e){
        StandardError err = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
