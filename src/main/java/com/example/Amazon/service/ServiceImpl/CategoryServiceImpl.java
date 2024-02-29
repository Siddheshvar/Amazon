package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Category;
import com.example.Amazon.repository.CategoryRepository;
import com.example.Amazon.service.CategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... category not found!"));
    }

    @Override
    public Category updateCategoryById(@NotNull Category category, long id) {
        Category existingCat = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... category not found to update!"));

        existingCat.setCategoryName(category.getCategoryName());
        existingCat.setCategoryDescription(category.getCategoryDescription());
        existingCat.setCategoryLink(category.getCategoryLink());

        return this.categoryRepository.save(existingCat);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... category not found to delete!"));
        categoryRepository.deleteById(id);
    }
}
