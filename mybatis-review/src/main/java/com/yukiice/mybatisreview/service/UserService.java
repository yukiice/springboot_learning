package com.yukiice.mybatisreview.service;

import com.yukiice.mybatisreview.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService{
    User addUser(User user);

    User getUserByName(String username);

    int getUserCount();

    Map<Integer,User> getUserListByMap(String username);


    List<User> getUserByLikeName(String username);

    int deleteUserMore(String id);
}
