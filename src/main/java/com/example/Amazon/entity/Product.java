package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String brand;
    private String productDescription;
    private Float productPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @OneToMany(mappedBy = "product")
//    private List<OrderItem> orderItems;

    private Boolean isDeleted;
    private Date createOn;
    private Date updateOn;

 }
