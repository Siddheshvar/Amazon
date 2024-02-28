package com.example.Amazon.service;

import com.example.Amazon.entity.OrderItem;
import java.util.List;

public interface OrderItemsService {
    OrderItem saveOrderItem(OrderItem orderItem);
    List<OrderItem> getAllOrderItem();
    OrderItem getOrderItemById(Integer id);
    OrderItem updateOrderItemById(OrderItem orderItem,Integer id);
    void deleteOrderItemById(Integer id);
}
