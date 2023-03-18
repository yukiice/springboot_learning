package com.example.separationproject.repo;

import com.example.separationproject.entity.data.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findAccountByUsername(String username);
}
