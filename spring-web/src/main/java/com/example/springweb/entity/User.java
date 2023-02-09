package com.example.springweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    int id;
    String username;
    String password;
    String auth;
}
