package com.example.Amazon.controller;

import com.example.Amazon.entity.OrderItem;
import com.example.Amazon.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping("/save")
    public ResponseEntity<String> saveOrderItem(@RequestBody OrderItem orderItem){
        orderItemsService.saveOrderItem(orderItem);
        return ResponseEntity.ok("");
    }

    @GetMapping("/getall")
    public List<OrderItem> getAllOrder(){
        return new ArrayList<OrderItem>(orderItemsService.getAllOrderItem());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id")Integer id){
        return new ResponseEntity<OrderItem>(orderItemsService.getOrderItemById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderItemById(@PathVariable("id")Integer id,
                                                      @RequestBody OrderItem orderItem){
        orderItemsService.updateOrderItemById(orderItem,id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable("id")Integer id){
        orderItemsService.deleteOrderItemById(id);
        return ResponseEntity.ok("");
    }
}
