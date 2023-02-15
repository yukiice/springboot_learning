package com.example.service;

import com.example.entity.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class RedisService {
    @Resource
    RedisTemplate<Object,Object> template;

    @PostConstruct
    public void init(){
        template.setEnableTransactionSupport(true);  // 开启事务
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
    }

    @Transactional  // 需要添加这个注解
    public void test(){
        template.multi();
        template.opsForValue().set("f",new Person());
        template.exec();
    }
}
