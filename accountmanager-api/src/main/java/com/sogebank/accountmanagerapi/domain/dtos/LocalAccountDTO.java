package com.sogebank.accountmanagerapi.domain.dtos;

import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalAccountDTO {
    
    private Long id;
    private String accountNumber;
    private AccountStatus status;
    private AccountType type;
    private Double balance ; 
    private Long user;
}
