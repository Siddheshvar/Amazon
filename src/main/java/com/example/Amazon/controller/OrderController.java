package com.example.Amazon.controller;

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
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        ordersService.saveOrder(order);
        return ResponseEntity.ok("");
    }
    @GetMapping("/getall")
    public List<Order> getAllOrder(){
        return new ArrayList<Order>(ordersService.getAllOrder());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(ordersService.getOrderById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable("id")Integer id,
                                                  @RequestBody Order order){
        ordersService.updateOrderById(order,id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(Integer id){
        ordersService.deleteOrderById(id);
        return ResponseEntity.ok("");
    }
}
