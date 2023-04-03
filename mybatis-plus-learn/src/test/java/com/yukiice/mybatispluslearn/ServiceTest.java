package com.yukiice.mybatispluslearn;

import com.yukiice.mybatispluslearn.entity.User;
import com.yukiice.mybatispluslearn.mapper.UserMapper;
import com.yukiice.mybatispluslearn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/28 14:43
 */
@Slf4j
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

//    @Test
    void firstTest(){
//        Map<String,Object> map  = userMapper.mySelectById(1L);
//        System.out.println(map);
       int count =  userService.count();
       System.out.println(count);
       log.info("总数量");

       List<User> users = userService.list();
        System.out.println(users);
    }

//    添加多个
//    @Test
    void testAddMore(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i <= 2 ; i++) {
            User user = new User();
            user.setName("花花"+i);
            user.setAge(18+i);
            user.setEmail(i+"@qq.com");
            list.add(user);
        }
        try {
            boolean res = userService.saveBatch(list);
            System.out.println(res);
            log.info("添加成功");
        }catch (Exception e){
            log.info("添加失败,原因为："+e);
        }
    }


//    测试逻辑删除
//    @Test
    public void testDelete(){
        List<Long> list = Arrays.asList(1L);
        int res = userMapper.deleteBatchIds(list);
        System.out.println(res);
        log.info("逻辑删除成功");
    }
//
}
