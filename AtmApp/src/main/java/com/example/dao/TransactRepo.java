package com.example.dao;

import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
