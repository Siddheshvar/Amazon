package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;


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
