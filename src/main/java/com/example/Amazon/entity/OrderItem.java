package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer itemQuantity;

//    @ManyToOne
//    @JoinColumn(name = "product_Id")
//    private Products products;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order order;
}
