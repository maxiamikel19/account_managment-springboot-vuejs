package com.sogebank.accountmanagerapi.domain.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.sogebank.accountmanagerapi.domain.LocalUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalUserDTO {

    private Long id;
    
    @NotBlank(message = "The name is required")
    private String name;

    @CPF(message = "Invalid CPF")
    @NotBlank(message = "The CPF is requiered")
    private String cpf;

    @NotBlank(message = "The email is requirerd")
    @Email(message = "The email is not valid")
    private String email;

    @NotBlank(message = "Username is requiered")
    private String username;

    @NotBlank(message = "A password is requiered")
    private String password;

    public LocalUserDTO(LocalUser obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.username = obj.getUsername();
    }
}
