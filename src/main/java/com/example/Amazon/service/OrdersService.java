package com.example.Amazon.service;

import com.example.Amazon.Requests.OrderRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Order;
import java.util.List;

public interface OrdersService {
    BaseResponse saveOrder(OrderRequest orderRequest);
    BaseResponse<List<Order>> getAllOrder();
    BaseResponse getOrderById(Integer id);
    BaseResponse updateOrderById(Order order,Integer id);

    BaseResponse deleteOrderById(Integer id);
}
