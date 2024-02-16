package com.example.Amazon.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId",nullable = false)
    private Long catId;

    @Column(name = "CategoryName")
    private String catName;

    @Column(name = "CategoryDescription")
    private String catDescription;


    @Column(name = "CategoryLink")
    private String catLink;

}
