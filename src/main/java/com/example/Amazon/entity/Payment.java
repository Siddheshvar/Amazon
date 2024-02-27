package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_Id")
    private Integer paymentId;

    private Double Amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private SignUp signUp;
}
