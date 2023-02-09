package com.example.springweb.mapper;

import com.example.springweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MainMapper {
    @Select("select * from users where username = #{username}")
    User finUserByName(String username);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into users(username, password, auth)  values (#{username}, #{password}, #{auth})")
    int registerUser(User user);

    @Insert("insert into  student(uid, name, sex, grade) VALUES (#{uid}, #{name}, #{sex}, #{grade})")
    int addStudentInfo(@Param("name") String name, @Param("sex") int sex, @Param("grade") String grade, @Param("uid") int uid);

}
