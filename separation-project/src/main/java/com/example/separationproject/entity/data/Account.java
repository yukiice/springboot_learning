package com.example.separationproject.entity.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;


}
