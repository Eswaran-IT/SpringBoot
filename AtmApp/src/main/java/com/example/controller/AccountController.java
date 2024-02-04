package com.example.controller;

import com.example.dto.AccountDto;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AccountDto AccountDto) {
        accountService.register(AccountDto);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountDto AccountDto) {
        accountService.login(AccountDto);
        return ResponseEntity.ok("Login successful");
    }

}
