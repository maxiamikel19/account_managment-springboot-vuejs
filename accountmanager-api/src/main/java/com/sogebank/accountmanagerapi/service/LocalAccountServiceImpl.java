package com.sogebank.accountmanagerapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.dtos.LocalAccountDTO;
import com.sogebank.accountmanagerapi.domain.dtos.LocalTransactionDTO;
import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.model.LocalAccountModel;
import com.sogebank.accountmanagerapi.repository.LocalAccountRepository;

@Service
public class LocalAccountServiceImpl implements LocalAccountService {

    private final LocalAccountRepository accountRepository;
    private final LocalUserServiceImpl userService;

    

    public LocalAccountServiceImpl(LocalAccountRepository accountRepository, LocalUserServiceImpl userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    @Override
    public LocalAccount createAccount(LocalAccountModel obj) {
        LocalUser localUser = userService.getUserById(obj.getUserId());

        LocalAccount localAccount = new LocalAccount();
        localAccount.setId(null);
        localAccount.setAccountNumber(generateAccountNumber(localUser));
        localAccount.setCreateAt(LocalDate.now());
        localAccount.setBalance(0.0);
        localAccount.setStatus(AccountStatus.OPEN);
        localAccount.setType(obj.getType());
        localAccount.setUser(localUser);
        
        return accountRepository.save(localAccount); 
    }

    private String generateAccountNumber(LocalUser localUser) {
        Integer sumCpf = getSumCpf(localUser.getCpf());
        Integer totalAccountNum = accountRepository.getCountAllAccounts();

        String accountNumber = sumCpf+"-"+totalAccountNum;
        return accountNumber;
    }

    private Integer getSumCpf(String cpf){
        int totalSum = 0;
        String temp = "0";

        for(int i = 0; i < cpf.length(); i+=1){
            char ch = cpf.charAt(i);

            if(Character.isDigit(ch)){
                temp += ch;
            }else{
                totalSum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return totalSum + Integer.parseInt(temp);
    }

    @Override
    public LocalAccountDTO deposite(String accountNumber, Double value) {
        return null;
    }

    @Override
    public LocalAccountDTO checkBalance(String accountNumber) {
        return null;
    }

    @Override
    public LocalTransactionDTO makeTransaction(LocalTransactionDTO obj) {
        return null;
    }
    
}
