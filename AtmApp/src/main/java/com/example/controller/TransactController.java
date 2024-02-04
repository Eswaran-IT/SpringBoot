
package com.example.controller;

import com.example.dto.Transactiondto;
import com.example.service.TransactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactController {

    @Autowired
    private TransactService transactService;

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody Transactiondto transactionDto) {
        transactService.deposit(transactionDto);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody Transactiondto transactionDto) {
        transactService.withdraw(transactionDto);
        return ResponseEntity.ok("Withdrawal successful");
    }

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<Double> getBalance(@PathVariable Long accountId) {
        Double balance = transactService.getBalance(accountId);
        return ResponseEntity.ok(balance);
    }
}
