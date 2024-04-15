package com.sogebank.accountmanagerapi.service;

import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionDTO;
import com.sogebank.accountmanagerapi.domain.model.LocalTransactionResponse;

public interface LocalTransactionService {
    
    public LocalTransactionResponse depositeAtAccount(LocalTransactionDTO obj);

    public LocalTransactionResponse retreiveToAccount(LocalTransactionDTO obj);
}
