package com.yukiice.mybatispluslearn.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author yukiice
 * @version 1.0
 * Create by 2023/3/27 10:37
 */
@Data
@TableName("user" )
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long uid;
    private String name;
    private Integer age;
    private String email;
    @TableLogic // 逻辑删除字段
    private Integer isDelete;
}
