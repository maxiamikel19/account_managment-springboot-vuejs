package com.sogebank.accountmanagerapi.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.model.LocalAccountModel;
import com.sogebank.accountmanagerapi.exception.ObjectBlockedException;
import com.sogebank.accountmanagerapi.exception.ObjectSearchNotFoundException;
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
    public void deposite(String accountNumber, Double value) {
       LocalAccount account = findByAccountNumber(accountNumber);
       if(isAccountNotBlocked(accountNumber)){
         account.setBalance(NumberFormatDecimalService.convertDoubleTwoDecimals(account.getBalance() + value));
         accountRepository.saveAndFlush(account);
       }else{
            throw new ObjectBlockedException("Account is now OFFLINE!, please contact your administrator");
       }
    }

    @Override
    public Double checkBalance(String accountNumber) {
        LocalAccount account = findByAccountNumber(accountNumber);
        Double balance = account.getBalance();
        return balance;
    }

    
    public boolean authorizeValue(Double balance, Double value) {
        if(balance >= value){
            return true;
        }else{
            return false;
        }
    }
    

    @Override
    public LocalAccount findByAccountNumber(String accountNumber) {
        Optional<LocalAccount> opAccount = accountRepository.findByAccountNumber(accountNumber);
        if(!opAccount.isPresent()){
            throw new ObjectSearchNotFoundException("Account number: "+accountNumber+" not found");
        }else{
            return opAccount.get();
        }
    }
    
    private Boolean isAccountNotBlocked(String accountNumber){
        LocalAccount account = findByAccountNumber(accountNumber);
        if(account.getStatus().equals(AccountStatus.LOCKED)){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public void retreive(String accountNumber, Double value) {
        LocalAccount account = findByAccountNumber(accountNumber);
       if(isAccountNotBlocked(accountNumber)){
         account.setBalance(NumberFormatDecimalService.convertDoubleTwoDecimals(account.getBalance() - value));
         accountRepository.saveAndFlush(account);
       }else{
            throw new ObjectBlockedException("Account is now OFFLINE!, please contact your administrator");
       }
    }
}
