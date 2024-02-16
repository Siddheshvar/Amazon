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
    public ResponseEntity<String>save(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok("Saved!");
    }

    @GetMapping("/getall")
    public List<Category>getAll(){
        return new ArrayList<Category>(categoryService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category>getById(@PathVariable("id")long id){
        return new ResponseEntity<Category>(categoryService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>updateById(@RequestBody Category category,
                                            @PathVariable("id")long id){
        categoryService.updateById(category,id);
        return ResponseEntity.ok("Updated category, Check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteById(@PathVariable("id")long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category Id no "+id+" deleted successfully!");
    }
}
