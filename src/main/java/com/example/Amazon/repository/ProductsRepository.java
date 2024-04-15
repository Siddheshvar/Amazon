package com.example.Amazon.repository;

import com.example.Amazon.entity.Category;
import com.example.Amazon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByIsDeletedAndProductNameAndBrand(boolean b, String productName, String brand);
    Optional<Product> findByIsDeletedAndId(boolean b, Integer id);
    List<Product> findByIsDeletedAndCategoryCategoryName(boolean b, String category);
}
