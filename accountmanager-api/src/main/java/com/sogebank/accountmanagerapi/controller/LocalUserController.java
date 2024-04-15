package com.sogebank.accountmanagerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogebank.accountmanagerapi.domain.dtos.LocalUserDTO;
import com.sogebank.accountmanagerapi.service.LocalUserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/users")
public class LocalUserController {
    

    private final LocalUserServiceImpl userService;

    public LocalUserController(LocalUserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> signUp(@Valid @RequestBody LocalUserDTO obj){
        return  new ResponseEntity<>(userService.signUp(obj), HttpStatus.CREATED);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<LocalUserDTO> getUserByCpf(@PathVariable String cpf){
        return ResponseEntity.ok().body(userService.getUserByCpf(cpf));
    }
}
