package com.example.Amazon.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String productName;
    private String brand;
    private String productDescription;
    private Float productPrice;
    private CategoryResponse categoryResponse;
}
