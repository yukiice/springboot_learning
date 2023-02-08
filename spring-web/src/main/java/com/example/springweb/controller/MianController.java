package com.example.springweb.controller;

import com.example.springweb.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MianController {

    @Value("${test.name}")
    String name;

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "hello" + name;
    }

    @RequestMapping(value = "/student")
    @ResponseBody
    public Student student(){
        Student student = new Student();
        student.setAge(18);
        student.setName("花花");
        student.setSex("男");
        return  student;
    }
}
