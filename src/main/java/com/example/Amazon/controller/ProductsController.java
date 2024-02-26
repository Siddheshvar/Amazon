package com.example.Amazon.controller;

import com.example.Amazon.entity.Products;
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
    public ResponseEntity<String> saveProducts(@RequestBody Products products){
        productsService.saveProduct(products);
        return ResponseEntity.ok("Product details are saved in DB,\nPlease check out.");
    }

    @GetMapping("/getall")
    public List<Products> getAllProducts(){
        return new ArrayList<Products>(productsService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable("id") long id){
        return new ResponseEntity<Products>(productsService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProductsById(@PathVariable("id")long id,
                                                     @RequestBody Products products){
        productsService.updateProductById(products,id);
        return ResponseEntity.ok("Product details of id "+id+" are updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductsById(@PathVariable("id") long id){
        productsService.deleteProductById(id);
        return ResponseEntity.ok("Product details of id no "+id+" are deleted successfully!");
    }
}
