package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private Integer orderId;

    private Date orderDate;
    private Float totalAmount;

    @OneToOne
    @JoinColumn(name = "address_Id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private SignUp signUp;

}