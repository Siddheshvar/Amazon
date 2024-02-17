package com.example.Amazon.service;

import com.example.Amazon.entity.Products;

import java.util.List;

public interface ProductsService {
    Products save(Products products);
    List<Products> getAll();
    Products getById(long id);
    Products updateById(Products products,long id);
    void deleteById(long id);
}
