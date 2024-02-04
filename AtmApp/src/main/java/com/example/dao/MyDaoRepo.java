package com.example.dao;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MyDaoRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
