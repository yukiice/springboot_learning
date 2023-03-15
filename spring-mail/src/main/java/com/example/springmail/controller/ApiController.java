package com.example.springmail.controller;

import com.example.springmail.entity.RestBean;
import com.example.springmail.service.VerifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/auth")
public class ApiController {
    @Resource
    VerifyService service;


    @RequestMapping(value = "/verify-code")
    public RestBean  verifyCode(@RequestParam("email") String mail){
        try {
            service.sendVerifyCode(mail);
            return  new RestBean(200,"发送成功");
        }catch (Exception e){
            return  new RestBean(500,"发送失败");
        }

    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public RestBean register(String username, String password, String email, String verify){
        if (service.doVerify(email,verify)){
            return  new RestBean(200,"注册成功");
        }else {
            return  new RestBean(500,"注册失败");
        }
    }
}
