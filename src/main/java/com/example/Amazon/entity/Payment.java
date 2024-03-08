package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String paymentMethod;
    private Double Amount;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
    @OneToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;
}
