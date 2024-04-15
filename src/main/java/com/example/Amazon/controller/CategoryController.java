package com.example.Amazon.controller;

import com.example.Amazon.Requests.CategoryRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.CategoryResponse;
import com.example.Amazon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public BaseResponse saveCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.saveCategory(categoryRequest);
    }

    @GetMapping("/getAll")
    public BaseResponse<List<CategoryResponse>> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/get/{id}")
    public BaseResponse getCategoryById(@PathVariable("id")Integer id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateCategoryById(@RequestBody CategoryRequest categoryRequest,
                                                     @PathVariable("id")Integer id){
        return categoryService.updateCategoryById(categoryRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteCategoryById(@PathVariable("id")Integer id){
        return categoryService.deleteCategoryById(id);
    }
}
