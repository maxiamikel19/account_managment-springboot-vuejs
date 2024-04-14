package com.sogebank.accountmanagerapi.service;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.dtos.LocalAccountDTO;
import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionDTO;

public interface LocalAccountService {

    public LocalAccount createAccount(LocalAccountDTO obj);

    public LocalAccountDTO deposite(String accountNumber, Double value);

    public LocalAccountDTO checkBalance(String accountNumber);

    public LocalTransactionDTO makeTransaction(LocalTransactionDTO obj);

}