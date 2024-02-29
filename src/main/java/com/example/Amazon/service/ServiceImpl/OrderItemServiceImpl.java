package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.OrderItem;
import com.example.Amazon.repository.OrderItemsRepository;
import com.example.Amazon.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemsService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return orderItemsRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Integer id) {
        return orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order item not found!"));
    }

    @Override
    public OrderItem updateOrderItemById(OrderItem orderItem, Integer id) {
        OrderItem oldItems = orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order item not found to update!"));

        oldItems.setItemQuantity(oldItems.getItemQuantity());
        return orderItemsRepository.save(oldItems);
    }

    @Override
    public void deleteOrderItemById(Integer id) {
        orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order item items not found!"));
    }
}
