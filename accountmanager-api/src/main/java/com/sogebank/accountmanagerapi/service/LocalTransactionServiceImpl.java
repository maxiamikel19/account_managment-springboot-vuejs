package com.sogebank.accountmanagerapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.LocalTransaction;
import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionDTO;
import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionRetreiveDTO;
import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.enums.TransactionType;
import com.sogebank.accountmanagerapi.domain.model.LocalTransactionResponse;
import com.sogebank.accountmanagerapi.exception.NullValueTransactionDetectedException;
import com.sogebank.accountmanagerapi.exception.ObjectBlockedException;
import com.sogebank.accountmanagerapi.exception.ObjectSearchNotFoundException;
import com.sogebank.accountmanagerapi.repository.LocalTransactionRepository;

@Service
@Transactional
public class LocalTransactionServiceImpl implements LocalTransactionService {

    private final LocalTransactionRepository transactionRepository;
    private final LocalAccountServiceImpl accountService;
    private final LocalUserServiceImpl userService;

    

    public LocalTransactionServiceImpl(LocalTransactionRepository transactionRepository,
            LocalAccountServiceImpl accountService, LocalUserServiceImpl userService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public LocalTransactionResponse depositeAtAccount(LocalTransactionDTO obj) {
        LocalAccount account = accountService.findByAccountNumber(obj.getAccountNumber());

        if(obj.getValue() <= 0){
            throw new NullValueTransactionDetectedException("Transaction value cannot be null");
        }

        accountService.deposite(account.getAccountNumber(), obj.getValue());

        LocalTransaction transaction = new LocalTransaction();
        transaction.setAccount(account);
        transaction.setCreateAt(LocalDate.now());
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setValue(obj.getValue());
        transaction.setUserCpf(obj.getUserCpf());
        transactionRepository.save(transaction);

        LocalTransactionResponse response = new LocalTransactionResponse();
        response.setAccountNumber(transaction.getAccount().getAccountNumber());
        response.setUserCpf(transaction.getUserCpf());
        response.setTransactionValue(transaction.getValue());
        response.setCreatAt(transaction.getCreateAt());
        response.setStatus("OK");
        return response;
    }

    @Override
    public LocalTransactionResponse retreiveToAccount(LocalTransactionRetreiveDTO obj) {
        LocalUser user = userService.getUserByUsername(obj.getUsername());
        if(obj.getPassword().equals(user.getPassword())){
            LocalAccount account = accountService.findByAccountNumber(obj.getAccountNumber());

            if(!(account.getStatus().equals(AccountStatus.OPEN))){
                throw new ObjectBlockedException("Account is not able to operate!");
            }else{
                if(accountService.authorizeValue(account.getBalance(), obj.getValue())){
                    LocalTransaction transaction = new LocalTransaction();
                    transaction.setAccount(account);
                    transaction.setCreateAt(LocalDate.now());
                    transaction.setType(TransactionType.WITHDRAW);
                    transaction.setUserCpf(user.getCpf());
                    transaction.setValue(NumberFormatDecimalService.convertDoubleTwoDecimals(obj.getValue()));
                    
                    account.setBalance(account.getBalance() - obj.getValue());
                    accountService.retreive(account.getAccountNumber(), obj.getValue());

                    transactionRepository.save(transaction);
                
                    LocalTransactionResponse response = new LocalTransactionResponse();
                    response.setAccountNumber(transaction.getAccount().getAccountNumber());
                    response.setUserCpf(transaction.getUserCpf());
                    response.setTransactionValue(transaction.getValue());
                    response.setCreatAt(transaction.getCreateAt());
                    response.setStatus("OK");
                    return response;
                }else{
                    throw new NullValueTransactionDetectedException("No available balance");
                }
            }
        }else
            throw new ObjectSearchNotFoundException("No verified user credentials");
        }

    
}
