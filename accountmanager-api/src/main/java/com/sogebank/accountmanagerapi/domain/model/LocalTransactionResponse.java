package com.sogebank.accountmanagerapi.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalTransactionResponse {
    private String accountNumber;
    private Double transactionValue;
    private String status;
    private LocalDate creatAt;
}
