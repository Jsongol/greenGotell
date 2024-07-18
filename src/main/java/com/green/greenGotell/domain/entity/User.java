package com.green.greenGotell.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "UserEntity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String resetToken;
}
