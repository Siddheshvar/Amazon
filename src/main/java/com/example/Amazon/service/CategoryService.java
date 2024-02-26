package com.example.Amazon.service;

import com.example.Amazon.entity.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(long id);
    Category updateCategoryById(Category category, long id);
    void deleteCategoryById(long id);
}
