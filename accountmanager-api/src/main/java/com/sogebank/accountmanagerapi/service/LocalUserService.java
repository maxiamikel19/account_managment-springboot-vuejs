package com.sogebank.accountmanagerapi.service;

import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.dtos.LocalUserDTO;

public interface LocalUserService {
    
    public LocalUserDTO signUp(LocalUserDTO obj);

    public LocalUserDTO getUserByCpf(String cpf);

    public LocalUser getUserById(Long id);
}
