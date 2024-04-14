package com.sogebank.accountmanagerapi.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.sogebank.accountmanagerapi.domain.dtos.LocalUserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "The name is required")
    private String name;

    @Column(name = "cpf", unique = true)
    @CPF(message = "Invalid CPF")
    @NotEmpty(message = "The CPF is requiered")
    private String cpf;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "The email is requirerd")
    @Email(message = "The email is not valid")
    private String email;

    @Column(name = "username")
    @NotEmpty(message = "Username is requiered")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "A password is requiered")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<LocalAccount> accounts ;

    public LocalUser(LocalUserDTO obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.username = obj.getUsername();
    }
}
