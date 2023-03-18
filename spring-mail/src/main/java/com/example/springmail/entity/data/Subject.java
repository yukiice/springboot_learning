package com.example.springmail.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")   //学科信息表
public class Subject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    @Id
    int cid;

    @Column(name = "name")
    String name;

    @JoinColumn(name = "tid")
    @ManyToOne(fetch = FetchType.LAZY)
    Teacher teacher;

    @Column(name = "time")
    int time;
}
