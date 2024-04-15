package com.sogebank.accountmanagerapi.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalTransactionRetreiveDTO {
    private String username;
    private String password;
    private String accountNumber;
    private Double value;
}
