package com.sogebank.accountmanagerapi.domain.dtos;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalAccountDTO {
    
    private Long id;
    private String accountNumber;
    private AccountStatus status;
    private AccountType type;
    private Double balance ; 
    private Long user;

    public LocalAccountDTO(LocalAccount obj){
        this.accountNumber = obj.getAccountNumber();
        this.balance = obj.getBalance();
        this.id = obj.getId();
        this.status = obj.getStatus();
        this.type = obj.getType();
        this.user = obj.getUser().getId();
    }
}
