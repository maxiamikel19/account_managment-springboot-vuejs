package com.sogebank.accountmanagerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogebank.accountmanagerapi.domain.model.LocalAccountModel;
import com.sogebank.accountmanagerapi.service.LocalAccountServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class LocalAccountController {

    private final LocalAccountServiceImpl accountService;

    public LocalAccountController(LocalAccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<?> signUp(@Valid @RequestBody LocalAccountModel obj){
        return  new ResponseEntity<>(accountService.createAccount(obj), HttpStatus.CREATED);
    }
    
}
