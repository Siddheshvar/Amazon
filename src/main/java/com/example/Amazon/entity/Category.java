package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id")
    private Long categoryId;

    private String categoryName;
    private String categoryDescription;
    private String categoryLink;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JoinColumn(name = "category_Id")
    private List<Products> products;



}
