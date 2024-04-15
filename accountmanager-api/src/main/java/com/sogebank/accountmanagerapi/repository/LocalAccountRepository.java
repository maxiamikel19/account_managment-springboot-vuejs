package com.sogebank.accountmanagerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sogebank.accountmanagerapi.domain.LocalAccount;

public interface LocalAccountRepository extends JpaRepository<LocalAccount, Long>{
    
    @Query("select count(c.id) as total from LocalAccount c")
    Integer getCountAllAccounts();

    @Query("select sum(c.id) as total from LocalAccount c")
    Integer getSumAllAccounts();

    Optional<LocalAccount> findByAccountNumber(String accountNumber);
}
