package com.example.config;

import com.example.cache.RedisMybatisCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class MainConfiguration {
    @Resource
    RedisTemplate<Object,Object> template;

    @PostConstruct
    public void init(){
        //把RedisTemplate给到RedisMybatisCache
        RedisMybatisCache.setTemplate(template);
    }
}
