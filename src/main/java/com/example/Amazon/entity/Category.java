package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id",nullable = false)
    private Long catId;

    @Column(name = "CategoryName")
    private String catName;

    @Column(name = "CategoryDescription")
    private String catDescription;


    @Column(name = "CategoryLink")
    private String catLink;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Products> products;

}
