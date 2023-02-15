package com.example;

import com.example.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
 class SpringRedisTestApplicationTests {
    @Resource
    StringRedisTemplate template;

    @Resource
    RedisService service;

    @Test
      void Test(){
        service.test();
    }
}
