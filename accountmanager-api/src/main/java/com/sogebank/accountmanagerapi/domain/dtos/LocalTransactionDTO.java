package com.sogebank.accountmanagerapi.domain.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalTransactionDTO {
    
    private Long id;
    private LocalDate createAt;
    private Double value;
    private String transactionType;
    private String accountNumber;
}
