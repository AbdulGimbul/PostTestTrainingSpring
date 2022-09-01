package com.example.userapi.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table (name = "tbl_user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Integer is_active;
}
