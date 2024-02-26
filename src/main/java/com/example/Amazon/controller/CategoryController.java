package com.example.Amazon.controller;

import com.example.Amazon.entity.Category;
import com.example.Amazon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return ResponseEntity.ok("Category is saved!");
    }

    @GetMapping("/getall")
    public List<Category> getAllCategory(){
        return new ArrayList<Category>(categoryService.getAllCategory());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")long id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategoryById(@RequestBody Category category,
                                                     @PathVariable("id")long id){
        categoryService.updateCategoryById(category,id);
        return ResponseEntity.ok("Category updated , \nPlease check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id")long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category Id no "+id+" is deleted successfully!");
    }
}
