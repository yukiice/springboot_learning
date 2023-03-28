package com.yukiice.mybatispluslearn;

import com.yukiice.mybatispluslearn.entity.User;
import com.yukiice.mybatispluslearn.mapper.UserMapper;
import com.yukiice.mybatispluslearn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class MybatisPlusLearnApplicationTests {
    @Autowired
    UserMapper mapper;

//    @Test
    void contextLoads() {
    List<User> list =  mapper.selectList(null);
    list.forEach(System.out::println);
    log.info("数据加载成功");
    }

//    @Test
    void testInsert(){
        User user = new User();
        user.setName("admin");
        user.setAge(18);
        user.setEmail("admin@qq.com");
        System.out.println(user);
        int res =  mapper.insert(user);
        System.out.println(res);
        log.info("添加成功");
    }

//    删除功能
//    @Test
    void testDelete(){
//        后面加L表示他是一个Long类型的数字
        int res = mapper.deleteById(1640237666022748162L);
        System.out.println(res);
        log.info("删除成功");
    }
//    @Test
    void mapDelete(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","admin");
        int res = mapper.deleteByMap(map);
        System.out.println(res);
        log.info("map方式删除成功");
    }

//    更新功能
//    @Test
    void testUpdate(){
        User user = new User();
        user.setUid(4L);
        user.setName("花花");
        int res = mapper.updateById(user);
        System.out.println(res);
        log.info("更新成功");
    }

//    @Test
    void testSelect(){
        User user = mapper.selectById(1L);
        System.out.println(user);
        List<Long> idList = Arrays.asList(1L,2L,3L);
        List<User> users = mapper.selectBatchIds(idList);
        System.out.println(users);
        log.info("查询成功");
    }

//    Map查询
//    @Test
    void mapSelect(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","花花");
        List<User> users = mapper.selectByMap(map);
        System.out.println(users);
        log.info("map查询成功");
    }
}
