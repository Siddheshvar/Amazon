package com.example.Amazon.controller;

import com.example.Amazon.entity.CartItems;
import com.example.Amazon.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cartitem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCartItem(@RequestBody CartItems cartItems){
        cartItemService.saveCartItem(cartItems);
        return ResponseEntity.ok("");
    }

    @GetMapping("/getall")
    public List<CartItems> getAllCartItem(){
        return new ArrayList<CartItems>(cartItemService.getAllCartItem());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartItems> getCartItemById(@PathVariable("id")Long id){
        return new ResponseEntity<CartItems>(cartItemService.getCartItemById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCartItemById(@PathVariable("id")Long id,
                                                     @RequestBody CartItems cartItems){
        cartItemService.updateCartItemById(cartItems,id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCartItemById(@PathVariable("id")Long id){
        cartItemService.deleteCartItemById(id);
        return ResponseEntity.ok("");
    }
}
