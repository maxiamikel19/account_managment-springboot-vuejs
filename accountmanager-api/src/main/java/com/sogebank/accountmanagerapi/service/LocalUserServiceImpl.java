package com.sogebank.accountmanagerapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sogebank.accountmanagerapi.domain.LocalUser;
import com.sogebank.accountmanagerapi.domain.dtos.LocalUserDTO;
import com.sogebank.accountmanagerapi.exception.ObjectExistsDuplicationException;
import com.sogebank.accountmanagerapi.exception.ObjectSearchNotFoundException;
import com.sogebank.accountmanagerapi.repository.LocalUserRepository;

@Service
public class LocalUserServiceImpl implements LocalUserService {

    private final LocalUserRepository userRepository;

    public LocalUserServiceImpl(LocalUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LocalUserDTO signUp(LocalUserDTO obj) {

        Optional<LocalUser> user = userRepository.findByCpf(obj.getCpf());
        if(user.isPresent()){
            throw new ObjectExistsDuplicationException("User CPF aleready exists");
        }

        user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new ObjectExistsDuplicationException("User EMAIL aleready exists");
        }

        LocalUser newUser = new LocalUser(obj);
        userRepository.save(newUser);

        return new LocalUserDTO(newUser);
    }

    @Override
    public LocalUserDTO getUserByCpf(String cpf) {

        Optional<LocalUser> user = userRepository.findByCpf(cpf);
        if(!user.isPresent()){
            throw new ObjectSearchNotFoundException("User CPF not found: "+ cpf);
        }
        LocalUserDTO userDto = new LocalUserDTO(user.get());
        return userDto;
    }

    @Override
    public LocalUser getUserById(Long id) {
        Optional<LocalUser> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new ObjectSearchNotFoundException("User ID not found: "+ id);
        }
        return user.get();
    }
    
}
