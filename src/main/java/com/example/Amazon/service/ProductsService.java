package com.example.Amazon.service;

import com.example.Amazon.entity.Products;

import java.util.List;

public interface ProductsService {
    Products saveProduct(Products products);
    List<Products> getAllProducts();
    Products getProductById(long id);
    Products updateProductById(Products products, long id);
    void deleteProductById(long id);
}
