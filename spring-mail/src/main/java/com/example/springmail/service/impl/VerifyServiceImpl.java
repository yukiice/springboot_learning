package com.example.springmail.service.impl;

import com.example.springmail.service.VerifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class VerifyServiceImpl implements VerifyService {
    @Resource
    JavaMailSender sender;

    @Resource
    StringRedisTemplate template;

    @Value("${spring.mail.username}")
    String from;

    @Override
    public void sendVerifyCode(String mail){
        SimpleMailMessage message = new SimpleMailMessage();
//        redis处理
        Random random  = new Random();
        int code =  random.nextInt(899999) + 100000;
        template.opsForValue().set("verify:code"+mail,code+"");
        //设置邮件标题
        message.setSubject("验证码为:"+code);
        //设置邮件内容
        message.setText("can can need");
        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
        message.setTo(mail);
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom("javatestyukiice@163.com");
        //OK，万事俱备只欠发送
        sender.send(message);

    }

    @Override
    public boolean doVerify(String mail, String code) {
        String string = template.opsForValue().get("verify:code"+mail);
        if (string == null) return false;
        return  string.equals(code);
    }
}
