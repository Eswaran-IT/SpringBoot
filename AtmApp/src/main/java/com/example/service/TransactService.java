package com.example.service;

import com.example.dao.TransactRepo;
import com.example.dto.Transactiondto;
import com.example.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactService {

    @Autowired
    private TransactRepo transactionRepo;

    @Transactional
    public void deposit(Transactiondto transactionDto) {
        // Implementation for deposit transaction
        Transaction depositTransaction = new Transaction();
        depositTransaction.setAccountId(transactionDto.getAccountId());
        depositTransaction.setAmount(transactionDto.getAmount());
        transactionRepo.save(depositTransaction);
    }

    @Transactional
    public void withdraw(Transactiondto transactionDto) {
        // Implementation for withdrawal transaction
        Transaction withdrawalTransaction = new Transaction();
        withdrawalTransaction.setAccountId(transactionDto.getAccountId());
        withdrawalTransaction.setAmount(-transactionDto.getAmount()); // Negative amount for withdrawal
        transactionRepo.save(withdrawalTransaction);
    }

    public Double getBalance(Long accountId) {
        // Implementation for getting account balance
        List<Transaction> transactions = transactionRepo.findByAccountId(accountId);
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }
}
