package com.example.springmail.service;

public interface VerifyService {
    void sendVerifyCode(String mail);

    public boolean doVerify(String mail,String code);
}
