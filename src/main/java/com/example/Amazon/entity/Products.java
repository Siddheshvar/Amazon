package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private Long productId;

    private String productName;
    private String productDescription;
    private Float productPrice;
    private String productLink;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;
}
