package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer itemQuantity;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Orders orders;
}
