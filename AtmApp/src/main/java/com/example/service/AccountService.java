package com.example.service;

import com.example.dao.MyDaoRepo;
import com.example.dto.AccountDto;
import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private MyDaoRepo accountRepository;

    public void register(AccountDto accountDto) {
        Account account = new Account();
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        accountRepository.save(account);
    }

    public void login(AccountDto accountDto) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(accountDto.getEmail());

        if (optionalAccount.isPresent() && accountDto.getPassword().equals(optionalAccount.get().getPassword())) {
            // Authentication successful
            System.out.println("Login successful");
        } else {
            // Invalid credentials
            System.out.println("Invalid credentials");
        }
    }
}
