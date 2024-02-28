package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_Id")
    private Long cartItemId;

    private int itemQty;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "cart_Id")
    private Cart cart;

}
