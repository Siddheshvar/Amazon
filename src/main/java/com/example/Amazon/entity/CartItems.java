package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int itemQty;

//    @ManyToOne
//    @JoinColumn(name = "product_Id")
//    private Product products;
//
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
