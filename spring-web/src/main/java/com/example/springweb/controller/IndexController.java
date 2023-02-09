package com.example.springweb.controller;

import com.example.springweb.entity.User;
import com.example.springweb.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger =LoggerFactory.getLogger(IndexController.class);
        logger.info("用户访问了一次主页");
        User user =  service.findUser(session);
        model.addAttribute("user",user);
        return  "/index";
    }
}
