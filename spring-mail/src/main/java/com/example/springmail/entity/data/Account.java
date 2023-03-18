package com.example.springmail.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "auth")
    String auth;

    @JoinColumn(name = "detail_id")
    //            这里可以设置懒加载，这样我们想要的时候才会拿到相关的详情
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//            我们还可以通过修改级联关联的操作相关设定来进行数据处理
//            ALL 所有操作都进行关联操作
//            PERSIST 插入操作时才进行关联操作
//            REMOVE 删除操作时候才进行关联操作
//            MERGE  修改操作时才进行关联操作
    AccountDetail detail;


//    一对多关联成绩表
    @JoinColumn(name = "uid")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    List<Score> scoreList;
}