package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Products;
import com.example.Amazon.repository.ProductsRepository;
import com.example.Amazon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
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

        existingPr.setProductName(products.getProductName());
        existingPr.setBrand(products.getBrand());
        existingPr.setProductDescription(products.getProductDescription());
        existingPr.setProductPrice(products.getProductPrice());
        existingPr.setProductLink(products.getProductLink());

        return this.productsRepository.save(existingPr);
    }

    @Override
    public void deleteProductById(long id) {
        productsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        productsRepository.deleteById(id);
    }
}
