package com.example.Amazon.service;

import com.example.Amazon.Requests.CategoryRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Category;

import java.util.List;

public interface CategoryService {

    BaseResponse saveCategory(CategoryRequest categoryRequest);
    BaseResponse<List<Category>> getAllCategory();
    BaseResponse getCategoryById(Integer id);
    BaseResponse updateCategoryById(CategoryRequest categoryRequest, Integer id);
    BaseResponse deleteCategoryById(Integer id);
}
