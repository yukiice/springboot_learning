package com.yukiice.mybatispluslearn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukiice.mybatispluslearn.entity.User;
import com.yukiice.mybatispluslearn.mapper.UserMapper;
import com.yukiice.mybatispluslearn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/28 14:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
