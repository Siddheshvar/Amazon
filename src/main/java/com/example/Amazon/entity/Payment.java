package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String paymentMethod;
    private Double Amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private SignUp signUp;

    private Boolean isDeleted;
    private Date createOn;
    private Date updateOn;
}
