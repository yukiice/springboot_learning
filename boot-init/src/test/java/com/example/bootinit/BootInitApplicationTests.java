package com.example.bootinit;

import com.example.student.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BootInitApplicationTests {

    @Resource
    Student student;

    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
