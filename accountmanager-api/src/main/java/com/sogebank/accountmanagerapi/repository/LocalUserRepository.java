package com.sogebank.accountmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogebank.accountmanagerapi.domain.LocalUser;

public interface LocalUserRepository extends JpaRepository<LocalUser, Long>{
    
}
