package com.example.separationproject.service.impl;

import com.example.separationproject.entity.data.Account;
import com.example.separationproject.repo.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements UserDetailsService {

    @Resource
    AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findAccountByUsername(username);
        if (account == null) throw new  UsernameNotFoundException("");
        return User.withUsername(account.getUsername()).password(account.getPassword()).roles("user").build();
    }
}
