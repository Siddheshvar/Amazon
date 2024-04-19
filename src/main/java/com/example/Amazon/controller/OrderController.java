package com.example.Amazon.controller;

import com.example.Amazon.Requests.OrderRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Order;
import com.example.Amazon.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/save")
    public BaseResponse saveOrder(@RequestBody OrderRequest orderRequest){
        return ordersService.saveOrder(orderRequest);
    }
    @GetMapping("/getAll")
    public BaseResponse getAllOrder(){
        return ordersService.getAllOrder();
    }

    @GetMapping("/get/{id}")
    public BaseResponse getOrderById(@PathVariable("id")Integer id){
        return ordersService.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateOrderById(@PathVariable("id")Integer id,
                                                  @RequestBody OrderRequest orderRequest){
        return ordersService.updateOrderById(orderRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteOrderById(Integer id){
        return ordersService.deleteOrderById(id);
    }
}
