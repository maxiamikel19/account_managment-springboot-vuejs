package com.sogebank.accountmanagerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionDTO;
import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionRetreiveDTO;
import com.sogebank.accountmanagerapi.domain.model.LocalAccountModel;
import com.sogebank.accountmanagerapi.service.LocalAccountServiceImpl;
import com.sogebank.accountmanagerapi.service.LocalTransactionServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class LocalAccountController {

    private final LocalAccountServiceImpl accountService;
    private final LocalTransactionServiceImpl transactionService;

    public LocalAccountController(LocalAccountServiceImpl accountService, LocalTransactionServiceImpl transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> signUp(@Valid @RequestBody LocalAccountModel obj){
        return  new ResponseEntity<>(accountService.createAccount(obj), HttpStatus.CREATED);
    }
    
    @PostMapping("/deposite")
    public ResponseEntity<?> deposite(@Valid @RequestBody LocalTransactionDTO obj){
        return  new ResponseEntity<>(transactionService.depositeAtAccount(obj), HttpStatus.CREATED);
    }

    @PostMapping("/retreive")
    public ResponseEntity<?> retreiveToAccount(@Valid @RequestBody LocalTransactionRetreiveDTO obj){
        return  new ResponseEntity<>(transactionService.retreiveToAccount(obj), HttpStatus.CREATED);
    }

   
}
