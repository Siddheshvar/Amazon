package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Order;
import com.example.Amazon.repository.OrderRepository;
import com.example.Amazon.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order not found!"));
    }

    @Override
    public Order updateOrderById(Order order, Integer id) {
        Order oldOrder = orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order not found to update!"));

        oldOrder.setOrderDate(order.getOrderDate());
        oldOrder.setTotalAmount(oldOrder.getTotalAmount());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... order not found to delete!"));
    }
}
