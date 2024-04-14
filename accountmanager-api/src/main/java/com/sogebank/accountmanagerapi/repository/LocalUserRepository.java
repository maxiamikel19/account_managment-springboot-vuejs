package com.sogebank.accountmanagerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogebank.accountmanagerapi.domain.LocalUser;


public interface LocalUserRepository extends JpaRepository<LocalUser, Long>{
    
    Optional<LocalUser> findByEmail(String email);

    Optional<LocalUser> findByCpf(String cpf);
    
}
