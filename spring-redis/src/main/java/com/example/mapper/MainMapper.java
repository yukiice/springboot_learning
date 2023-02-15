package com.example.mapper;

import com.example.cache.RedisMybatisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@CacheNamespace(implementation = RedisMybatisCache.class)
@Mapper
public interface MainMapper {
    @Select("select name from student where sid = 11")
    String getSid();
}
