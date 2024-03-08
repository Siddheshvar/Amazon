package com.example.Amazon.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date orderDate;
    private Float totalAmount;

//    @OneToOne
//    @JoinColumn(name = "address_Id")
//    private Address address;
//

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

}