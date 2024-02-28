package com.example.Amazon.service;

import com.example.Amazon.entity.Order;
import java.util.List;

public interface OrdersService {
    Order saveOrder(Order order);
    List<Order> getAllOrder();
    Order getOrderById(Integer id);
    Order updateOrderById(Order order);
    void deleteOrderById(Integer id);
}
