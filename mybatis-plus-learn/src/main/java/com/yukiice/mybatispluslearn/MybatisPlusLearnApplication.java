package com.yukiice.mybatispluslearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yukiice.mybatispluslearn.mapper")
public class MybatisPlusLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusLearnApplication.class, args);
    }

}
