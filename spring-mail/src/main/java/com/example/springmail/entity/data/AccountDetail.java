package com.example.springmail.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_detail")
public class AccountDetail {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(name = "address")
    String address;

    @Column(name = "email")
    String mail;

    @Column(name = "phone")
    String phone;

    @Column(name = "name")
    String name;

}
