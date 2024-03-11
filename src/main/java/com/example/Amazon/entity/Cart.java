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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    private List<Product> products;                    //  new

//    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Product> products;

}
