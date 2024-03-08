package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String categoryName;
    private String categoryDescription;
    private String categoryLink;


}
