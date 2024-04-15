package com.sogebank.accountmanagerapi.domain.model;

import com.sogebank.accountmanagerapi.domain.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalAccountModel {
    private AccountType type;
    private Long userId;
}
