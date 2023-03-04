package com.example.springmail;
import com.example.springmail.entity.Account;
import com.example.springmail.repo.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Resource
    AccountRepository accountRepository;
    @Test
    void contextLoads(){
//        查询操作
        accountRepository.findById(1).ifPresent(System.out::println);

//        删除操作
//        accountRepository.deleteById(2);
    }

//    新增数据
//    @Test
    void  addAccount(){
        Account account = new Account();
        account.setAuth("admin");
        account.setUsername("huahua");
        account.setPassword("123456");
        account = accountRepository.save(account);
        System.out.println("插入后拿到的id为："+account.getId());
    }

//    分页操作
    @Test
    void  pageChange(){
        accountRepository.findAll(PageRequest.of(0,2)).forEach(System.out::println);
    }
}
