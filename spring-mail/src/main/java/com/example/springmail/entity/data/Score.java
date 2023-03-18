package com.example.springmail.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_score")
public class Score {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    int id;

    @OneToOne   //一对一对应到学科上
    @JoinColumn(name = "cid")
    Subject subject;

    @Column(name = "socre")
    double score;

    @Column(name = "uid")
    int uid;
}
