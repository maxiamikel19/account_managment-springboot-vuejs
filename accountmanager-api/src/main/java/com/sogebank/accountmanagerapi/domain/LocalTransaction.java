package com.sogebank.accountmanagerapi.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.sogebank.accountmanagerapi.domain.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class LocalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate createAt;

    private Double value;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "user_cpf")
    @NotEmpty(message = "CPF cannot be null!")
    @CPF(message = "Invalid CPF")
    private String userCpf;

    @ManyToOne
    @JoinColumn(name = "local_account_id")
    private LocalAccount account;
}
