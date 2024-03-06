package com.example.Amazon.controller;

import com.example.Amazon.entity.Category;
import com.example.Amazon.entity.Products;
import com.example.Amazon.service.CategoryService;
import com.example.Amazon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("/home")
    public String adminHome(){
        return "Admin Home";
    }
    @GetMapping("categories")
    public String getCategory(){
        return "Categories";
    }
    @GetMapping("categories/add")
    public String addCategory(){
        return "Category";
    }

    @PostMapping("categories/add")
    public ResponseEntity<String> saveCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok("Category is added!");
    }

    public ResponseEntity<String> saveProduct(@RequestBody Products products){
        productsService.saveProduct(products);
        return ResponseEntity.ok("Product is added!");
    }
}
