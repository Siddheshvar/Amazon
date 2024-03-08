package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

}
