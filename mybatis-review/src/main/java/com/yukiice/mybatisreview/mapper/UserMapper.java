package com.yukiice.mybatisreview.mapper;

import com.yukiice.mybatisreview.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
//    int insertUser();
   List<User> getAllUser();

   int insertUser(User user);

   User getUserBy(@Param("username") String username);

   int getUserCount();

   @MapKey("id")
   Map<Integer,User> getUserListByMap(@Param("username") String username);

//   模糊查询
   List<User> getUserByLikeName(@Param("username") String username);
}
