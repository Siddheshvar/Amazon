package com.example.Amazon.repository;

import com.example.Amazon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByIsDeleted(boolean b);
    Optional<Order> findByIsDeletedAndId(boolean b, Integer id);
    Optional<Order> findByIsDeletedAndId(Integer id);
}
