package com.sogebank.accountmanagerapi.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalUserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String username;
    private String password;
}
