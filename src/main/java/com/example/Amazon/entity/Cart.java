package com.example.Amazon.entity;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Id")
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private SignUp signUp;

}
