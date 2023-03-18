package com.example.separationproject.service;

import java.security.NoSuchAlgorithmException;

public interface AccountService {
    public void createAccount(String username,String password) throws NoSuchAlgorithmException;

}
