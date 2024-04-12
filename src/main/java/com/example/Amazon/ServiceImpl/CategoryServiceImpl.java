package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.CategoryRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Category;
import com.example.Amazon.repository.CategoryRepository;
import com.example.Amazon.service.CategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BaseResponse saveCategory(CategoryRequest categoryRequest) {
        Optional<Category> category = categoryRepository.findByIsDeletedAndCategoryName(false, categoryRequest.getCategoryName());
        if (!category.isPresent()) {
            Category category1 = new Category();
            category1.setCategoryName(categoryRequest.getCategoryName());
            category1.setCategoryDescription(categoryRequest.getCategoryDescription());
            category1.setIsDeleted(false);
            category1.setCreateOn(new Date());
            categoryRepository.save(category1);
            return new BaseResponse(200, "Category saved successfully", category1.getCategoryName());
        }else{
            return new BaseResponse(404, "Category already exists", category.get().getCategoryName());
        }
    }

    @Override
    public BaseResponse<List<Category>> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        if (!category.isEmpty()){
            List<Category> categoryArrayList = categoryRepository.findAll();
            return new BaseResponse(200, "Category retrieved successfully", categoryArrayList);
        }else {
            return new BaseResponse(404, "No category found", null);
        }
    }

    @Override
    public BaseResponse getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findByIsDeletedAndId(false,id);
        if (category.isPresent()){
            Category category1 = categoryRepository.findById(id).get();
            return new BaseResponse(200, "Category retrieved successfully", category1);
        }else{
            return new BaseResponse(404,"No category found",null);
        }
    }

    @Override
    public BaseResponse updateCategoryById(@NotNull CategoryRequest categoryRequest, Integer id) {
        Optional<Category> category = categoryRepository.findByIsDeletedAndId(false,id);
        if (category.isPresent()) {
            Optional<Category> NCategory = categoryRepository.findByIsDeletedAndCategoryName(false,categoryRequest.getCategoryName());
            if (!NCategory.isPresent()) {
                category.get().setCategoryName(categoryRequest.getCategoryName());
                category.get().setCategoryDescription(categoryRequest.getCategoryDescription());
                category.get().setIsDeleted(false);
                category.get().setUpdateOn(new Date());
                categoryRepository.save(category.get());
                return new BaseResponse(200, "Category updated successfully", category.get().getCategoryName());
            }else {
                return new BaseResponse(404, "Category already exists", NCategory.get().getCategoryName());
            }
        }else {
            return new BaseResponse(404, "No such Category exists",null);
        }
    }

    @Override
    public BaseResponse deleteCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findByIsDeletedAndId(false,id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return new BaseResponse(200, "Category deleted successfully", category.get().getCategoryName());
        }else {
            return new BaseResponse(404, "No such Category exists",null);
        }
    }
}
