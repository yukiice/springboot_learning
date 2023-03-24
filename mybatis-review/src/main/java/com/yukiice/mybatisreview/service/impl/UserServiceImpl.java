package com.yukiice.mybatisreview.service.impl;

import com.yukiice.mybatisreview.entity.User;
import com.yukiice.mybatisreview.mapper.UserMapper;
import com.yukiice.mybatisreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/22 11:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User addUser(User user) {
        System.out.println(user);
        int res = mapper.insertUser(user);
        System.out.println(res);
        return null;
    }

    @Override
    public User getUserByName(String username){
        return mapper.getUserBy(username);
    }

    @Override
    public int getUserCount() {
        return mapper.getUserCount();
    }

    @Override
    public Map<Integer, User> getUserListByMap(String username) {
        return mapper.getUserListByMap(username);
    }

    @Override
    public List<User> getUserByLikeName(String username){
        return  mapper.getUserByLikeName(username);
    }


}
