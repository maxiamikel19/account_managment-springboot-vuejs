package com.sogebank.accountmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogebank.accountmanagerapi.domain.LocalAccount;

public interface LocalAccountRepository extends JpaRepository<LocalAccount, Long>{
    
}
