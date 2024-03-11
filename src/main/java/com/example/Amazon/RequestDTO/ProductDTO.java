package com.example.Amazon.RequestDTO;

import lombok.Data;

@Data
public class ProductDTO {

    private Integer id;
    private String productName;
    private String brand;
    private String productDescription;
    private Float productPrice;
    private String productLink;
}
