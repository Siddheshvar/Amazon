package com.example.Amazon.service;

import com.example.Amazon.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    List<Category> getAll();
    Category getById(long id);
    Category updateById(Category category,long id);
    void deleteById(long id);
}
