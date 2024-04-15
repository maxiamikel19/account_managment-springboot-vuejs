package com.sogebank.accountmanagerapi.domain.dtos;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalTransactionDTO {
    
    private Long id;
    private LocalDate createAt;
    private String transactionType;
    @NotEmpty(message = "Account number cannot be null!")
    private String accountNumber;
    @NotEmpty(message = "CPF cannot be null!")
    @CPF(message = "Invalid CPF")
    private String userCpf;
    private Double value;
}
