package com.example.Amazon.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "signup")
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Long phoneNo;
    private String emailId;
    private String createPass;
}
