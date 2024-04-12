package com.example.Amazon.repository;

import com.example.Amazon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByIsDeletedAndCategoryName(boolean b, String categoryName);

    Optional<Category> findByIsDeletedAndId(boolean b, Integer id);

}
