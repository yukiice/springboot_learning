package com.example.springweb.service;

import com.example.springweb.mapper.MainMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService  implements UserDetailsService {

    @Resource
    MainMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.springweb.entity.User user = mapper.finUserByName(username);
        if(user == null)
            throw new UsernameNotFoundException("登录失败，用户名或密码错误！");
        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getAuth())
                .build();
    }
}
