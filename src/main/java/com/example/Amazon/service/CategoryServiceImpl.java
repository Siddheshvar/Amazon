package com.example.Amazon.service;

import com.example.Amazon.entity.Category;
import com.example.Amazon.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Category updateById(@NotNull Category category, long id) {
        Category existingCat = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        existingCat.setCatName(category.getCatName());
        existingCat.setCatDescription(category.getCatDescription());
//        existingCat.setCatPrice(category.getCatPrice());
        existingCat.setCatLink(category.getCatLink());

        return this.categoryRepository.save(existingCat);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        categoryRepository.deleteById(id);
    }
}
