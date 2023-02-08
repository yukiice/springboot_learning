package com.example.springweb.mapper;

import com.example.springweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {
    @Select("select * from users where username = #{username}")
    User finUserByName(String username);
}
