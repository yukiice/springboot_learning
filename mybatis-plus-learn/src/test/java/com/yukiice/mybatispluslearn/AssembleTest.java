package com.yukiice.mybatispluslearn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yukiice.mybatispluslearn.entity.User;
import com.yukiice.mybatispluslearn.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/4/3 11:30
 */
@SpringBootTest
@Slf4j
public class AssembleTest {

    @Autowired
    private UserMapper userMapper;

//    @Test
    void  testWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","花").between("age",15,19).isNotNull("email");
        List<User> list =  userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

//    组装排序
//    @Test
    void orderWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
                List<User> list =  userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

//    删除
//    @Test
    void deleteWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int res  = userMapper.delete(queryWrapper);
        System.out.println(res);
        log.info("删除成功");
    }

//    @Test
    void AndWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20).like("name","花").or().isNull("email");
        User user = new User();
        user.setName("测试");
        user.setAge(20);
        user.setEmail("11@qq.com");
        int res = userMapper.update(user,queryWrapper);
        System.out.println(res);
        log.info("修改成功");
    }

//
//    @Test
    void conditionWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","花").and(i->i.gt("age",19).or().isNull("email"));
        User user = new User();
        user.setName("花花测试1");
        user.setAge(20);
        user.setEmail("22@qq.com");
        int res =  userMapper.update(user,queryWrapper);
        System.out.println(res);
        log.info("更新成功");
    }

    @Test
    void lambdaWrapper(){
        String name = "花";
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),User::getName,name);
        List<User> users =  userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
}
