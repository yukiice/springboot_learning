package com.yukiice.mybatisreview;

import com.yukiice.mybatisreview.entity.User;
import com.yukiice.mybatisreview.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisReviewApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.getAllUser();
        System.out.println(users);
    }

}
