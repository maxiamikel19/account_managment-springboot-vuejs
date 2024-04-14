package com.sogebank.accountmanagerapi.config;

import java.time.LocalDate;
import java.util.Arrays;

import com.sogebank.accountmanagerapi.domain.LocalAccount;
import com.sogebank.accountmanagerapi.domain.LocalTransaction;
import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.enums.AccountStatus;
import com.sogebank.accountmanagerapi.domain.enums.AccountType;
import com.sogebank.accountmanagerapi.domain.enums.TransactionType;
import com.sogebank.accountmanagerapi.repository.LocalAccountRepository;
import com.sogebank.accountmanagerapi.repository.LocalTransactionRepository;
import com.sogebank.accountmanagerapi.repository.LocalUserRepository;

//@Configuration
public class DBInitializer {

    private final LocalUserRepository userRepository;
    private final LocalAccountRepository accountRepository;
    private final LocalTransactionRepository transactionRepository;

    

    public DBInitializer(LocalUserRepository userRepository, LocalAccountRepository accountRepository,
            LocalTransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }



    //@Bean
    public String initlalizeBD(){
        
        LocalUser user = LocalUser.builder()
                .cpf("703.845.972-46")
                .email("amikel@maxi.com")
                .name("Amikel Maxi")
                .password("1234")
                .username("amikel")
                .build();

        LocalUser user1 = LocalUser.builder()
                .cpf("012.824.319-86")
                .email("myrlande@maxi.com")
                .name("Myrlande Louissaint Maxi")
                .password("1234")
                .username("myrlande")
                .build();

        LocalAccount account = LocalAccount.builder()
                    .accountNumber("AC009-10")
                    .balance(0.0)
                    .user(user1)
                    .status(AccountStatus.LOCKED)
                    .type(AccountType.SAVING_ACCOUNT)
                    .build();

        LocalAccount account1 = LocalAccount.builder()
                    .accountNumber("AC009-12")
                    .balance(0.0)
                    .user(user)
                    .status(AccountStatus.OPEN)
                    .type(AccountType.SAVING_ACCOUNT)
                    .build();

        LocalAccount account2 = LocalAccount.builder()
                    .accountNumber("AC009-11")
                    .balance(0.0)
                    .user(user1)
                    .status(AccountStatus.OPEN)
                    .type(AccountType.SAVING_ACCOUNT)
                    .build();
        
        LocalTransaction transaction = LocalTransaction.builder()
                    .account(account1)
                    .createAt(LocalDate.now())
                    .value(20.0)
                    .type(TransactionType.DEPOSIT)
                    .build();

        LocalTransaction transaction1 = LocalTransaction.builder()
                    .account(account2)
                    .createAt(LocalDate.now())
                    .value(9.0)
                    .build();

        LocalTransaction transaction2 = LocalTransaction.builder()
                    .account(account1)
                    .createAt(LocalDate.now())
                    .value(24.0)
                    .build();

        userRepository.saveAllAndFlush(Arrays.asList(user, user1));
        accountRepository.saveAllAndFlush(Arrays.asList(account, account1, account2));
        transactionRepository.saveAllAndFlush(Arrays.asList(transaction, transaction1, transaction2));

        return "====== OK ======";
    }
}
