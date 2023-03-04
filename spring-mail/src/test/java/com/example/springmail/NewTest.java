package com.example.springmail;

import com.example.springmail.entity.Account;
import com.example.springmail.repo.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class NewTest {
    @Resource
    AccountRepository repository;

    @Transactional
    @Test
    void  getData(){
        repository.findById(2).ifPresent(account -> {
            account.getScoreList().forEach(System.out::println);
        });
    }

//    修改密码
    @Test
    void changePwd(){
        int i = repository.updatePasswordById("admin","333");
        System.out.println(i);
    }
}
