package com.example.separationproject.service.impl;

import com.example.separationproject.entity.data.Account;
import com.example.separationproject.repo.AccountRepository;
import com.example.separationproject.service.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository repository;


    @Override
    public void createAccount(String username, String password) throws NoSuchAlgorithmException {
        Account account = new Account();
        account.setUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(password));
        repository.save(account);
    }
}
