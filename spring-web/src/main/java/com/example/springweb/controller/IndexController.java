package com.example.springweb.controller;

import com.example.springweb.entity.User;
import com.example.springweb.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/page/user")
public class IndexController {

    @Resource
    AuthService service;

    @RequestMapping(value = "/index")
    public String index(HttpSession session, Model model){
        User user =  service.findUser(session);
        model.addAttribute("user",user);
        return  "/index";
    }
}
