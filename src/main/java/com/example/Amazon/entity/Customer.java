package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private Long customerId;

    private String fullName;
    private Integer phoneNo;
    private String emailId;
    private String createPass;
}
