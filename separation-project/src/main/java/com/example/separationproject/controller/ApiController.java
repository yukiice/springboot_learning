package com.example.separationproject.controller;

import com.example.separationproject.entity.bean.RestBean;
import com.example.separationproject.service.AccountService;
import com.example.separationproject.service.VerifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(value = "/api/auth")
public class ApiController {
    @Resource
    VerifyService service;

    @Resource
    AccountService accountService;


    @RequestMapping(value = "/verify-code")
    public RestBean<Void> verifyCode(@RequestParam("email") String mail){
        System.out.println(mail);
        try {
            service.sendVerifyCode(mail);
            return  new RestBean<Void>(200,"发送成功");
        }catch (Exception e){
            return  new RestBean<Void>(500,"发送失败");
        }

    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public RestBean<Void> register(String username, String password, String email, String verify) throws NoSuchAlgorithmException {
        if (service.doVerify(email,verify)){
            accountService.createAccount(username,password);
            return  new RestBean<Void>(200,"注册成功");
        }else {
            return  new RestBean<Void>(500,"注册失败");
        }
    }
}
