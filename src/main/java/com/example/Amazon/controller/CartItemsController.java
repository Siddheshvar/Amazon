package com.example.Amazon.controller;

import com.example.Amazon.entity.CartItems;
import com.example.Amazon.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cartitems")
public class CartItemsController {
    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody CartItems items){
        cartItemsService.saveItem(items);
        return ResponseEntity.ok("Cart items saved!");
    }

    @GetMapping("/getall")
    public List<CartItems> getAllItems(){
        return new ArrayList<CartItems>(cartItemsService.getAllItems());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartItems> getById(@PathVariable("id")long id){
        return new ResponseEntity<CartItems>(cartItemsService.getItemById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id")long id,
                                             @RequestBody CartItems items){
        cartItemsService.updateItemById(items,id);
        return ResponseEntity.ok("Cart Item of ID "+id+" are updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id")long id){
        cartItemsService.deleteItemById(id);
        return ResponseEntity.ok("cart item of ID "+id+" are updated!");
    }
}
