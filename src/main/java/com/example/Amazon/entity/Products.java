package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private String brand;
    private String productDescription;
    private Float productPrice;
    private String productLink;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

 }
