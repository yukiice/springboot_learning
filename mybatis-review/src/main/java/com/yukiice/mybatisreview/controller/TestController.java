package com.yukiice.mybatisreview.controller;

import com.yukiice.mybatisreview.entity.ResBody;
import com.yukiice.mybatisreview.entity.User;
import com.yukiice.mybatisreview.mapper.UserMapper;
import com.yukiice.mybatisreview.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/18 16:27
 */

@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService service;

    @GetMapping(value = "")
    public String test(){
        List<User> users = userMapper.getAllUser();
        System.out.println(users);
        return users.toString();
    }

    @PostMapping(value = "")
    public String addTest(@RequestBody User body){
        System.out.println(body);
        System.out.println("=======");
        service.addUser(body);
        return  "OK";
    }

    @GetMapping(value = "name")
    public String conditionTest(@RequestParam("username") String username){
        User user =  service.getUserByName(username);
        System.out.println(user);
        return  "ok";
    }

    @GetMapping(value = "count")
    public Integer getCount(){
        int count = service.getUserCount();
        return  count;
    }

    @GetMapping(value = "map")
    public Map<Integer,User> getMapList(@RequestParam("username") String username){
        Map<Integer,User>  map = service.getUserListByMap(username);
        System.out.println(map);
        return  map;
    }
}
