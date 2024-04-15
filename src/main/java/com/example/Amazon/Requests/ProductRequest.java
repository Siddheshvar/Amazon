package com.example.Amazon.Requests;

import com.example.Amazon.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;
    private String brand;
    private String productDescription;
    private Float productPrice;
    private Integer category;

}
