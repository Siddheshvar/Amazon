package com.example.Amazon.controller;

import com.example.Amazon.Requests.ProductRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Product;
import com.example.Amazon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping("/save")
    public BaseResponse saveProducts(@RequestBody ProductRequest productsRequest){
        return productsService.saveProduct(productsRequest);
    }

    @GetMapping("/getAll")
    public BaseResponse getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/getCatProduct")
    public BaseResponse getAllProductsByCategory(@RequestParam String category){
        return productsService.getAllProductsByCategory(category);
    }

    @GetMapping("/get/{id}")
    public BaseResponse getProductsById(@PathVariable("id") Integer id){
        return productsService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateProductsById(@PathVariable("id")Integer id,
                                                     @RequestBody ProductRequest productsRequest){
        return productsService.updateProductById(productsRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteProductsById(@PathVariable("id") Integer id){
        return productsService.deleteProductById(id);
    }
}
