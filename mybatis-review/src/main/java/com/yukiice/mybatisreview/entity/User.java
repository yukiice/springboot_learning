package com.yukiice.mybatisreview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/18 14:46
 */
@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String email;
}
