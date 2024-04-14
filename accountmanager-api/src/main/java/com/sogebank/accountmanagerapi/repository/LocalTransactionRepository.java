package com.sogebank.accountmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogebank.accountmanagerapi.domain.LocalTransaction;

public interface LocalTransactionRepository extends JpaRepository<LocalTransaction, Long>{
    // @Query(value = "SELECT SUM(value) as valur FROM local_transaction where local_account_id = id and type = DEPOSIT ", nativeQuery = true)
    // Double findValueByAccountNumber(@Param("id") Long id);
}
