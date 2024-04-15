package com.sogebank.accountmanagerapi.service;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.model.LocalAccountModel;

public interface LocalAccountService {

    public LocalAccount createAccount(LocalAccountModel obj);

    public void deposite(String accountNumber, Double value);

    public void retreive(String accountNumber, Double value);
    
    LocalAccount findByAccountNumber(String accountNumber);

    public Double checkBalance(String accountNumber);
}
