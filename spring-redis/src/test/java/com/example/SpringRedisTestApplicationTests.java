package com.example;

import com.example.mapper.MainMapper;
import com.example.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
 class SpringRedisTestApplicationTests {
    @Resource
    StringRedisTemplate template;

    @Resource
    RedisService service;

    @Autowired
    MainMapper mapper;

    @Test
    void Test(){
//        service.test();
        System.out.println(mapper.getSid());
        System.out.println(mapper.getSid());
    }
}
