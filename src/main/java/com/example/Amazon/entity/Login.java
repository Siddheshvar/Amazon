package com.example.Amazon.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailId;
    private String password;
}
