package com.example.springweb.controller;

import com.example.springweb.entity.Student;
import com.example.springweb.entity.User;
import com.example.springweb.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RequestMapping("/page/auth")
@Controller
public class MainController {

    @Resource
    AuthService service;

    @Value("${test.name}")
    String name;

//    用户登录页面
    @RequestMapping(value = "/login")
    public String login(){
        return  "login";
    }

//    用户注册
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("auth") String auth, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("sex") int sex){
        service.register(auth,username,password,name,sex);
        return  "redirect:/page/auth/login";
    }

    @RequestMapping(value = "/student")
    @ResponseBody
    public Student student(){
        Student student = new Student();
        student.setAge(18);
        student.setName("花花");
        student.setSex("男");
        return  student;
    }
}
