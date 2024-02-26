package com.example.Amazon.service;

import com.example.Amazon.entity.Products;
import com.example.Amazon.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products saveProduct(Products products) {
        return this.productsRepository.save(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return this.productsRepository.findAll();
    }

    @Override
    public Products getProductById(long id) {
        return this.productsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Products updateProductById(Products products, long id) {
        Products existingPr = productsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        existingPr.setPrName(products.getPrName());
        existingPr.setPrDescription(products.getPrDescription());
        existingPr.setPrPrice(products.getPrPrice());
        existingPr.setPrLink(products.getPrLink());

        return this.productsRepository.save(existingPr);
    }

    @Override
    public void deleteProductById(long id) {
        productsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        productsRepository.deleteById(id);
    }
}