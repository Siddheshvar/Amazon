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
    public ResponseEntity<String> save(@RequestBody Products products){
        productsService.save(products);
        return ResponseEntity.ok("Product details are saved in DB check ot out.");
    }

    @GetMapping("/getall")
    public List<Products> getAll(){
        return new ArrayList<Products>(productsService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Products> getById(@PathVariable("id") long id){
        return new ResponseEntity<Products>(productsService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id")long id,
                                             @RequestBody Products products){
        productsService.updateById(products,id);
        return ResponseEntity.ok("Product details of id "+id+" are updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        productsService.deleteById(id);
        return ResponseEntity.ok("Product details of is "+id+" are deleted successfully!");
    }
}
