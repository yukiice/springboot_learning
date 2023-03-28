package com.yukiice.mybatispluslearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yukiice.mybatispluslearn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    根据id查看用户信息
    Map<String,Object> mySelectById(Long id);
}
