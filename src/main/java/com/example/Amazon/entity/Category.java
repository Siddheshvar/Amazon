package com.example.Amazon.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    private String catName;
    private String catDescription;
    private Float catPrice;
    private String catLink;

}
