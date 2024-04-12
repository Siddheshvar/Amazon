package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    private String categoryDescription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;


    private Boolean isDeleted;
    private Date createOn;
    private Date updateOn;
}
