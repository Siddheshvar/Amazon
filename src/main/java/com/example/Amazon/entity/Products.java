package com.example.Amazon.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long prId;

    @Column(name = "ProductName")
    private String prName;

    @Column(name = "ProductDescription")
    private String prDescription;

    @Column(name = "ProductPrice")
    private Float prPrice;

    @Column(name = "ProductLink")
    private String prLink;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
