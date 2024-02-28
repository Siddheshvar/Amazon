package com.example.Amazon.controller;

import com.example.Amazon.entity.Cart;
import com.example.Amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCart(@RequestBody Cart cart){
        cartService.saveCart(cart);
        return ResponseEntity.ok("");
    }

    @GetMapping("/getall")
    public List<Cart> getAllCart(){
        return new ArrayList<Cart>(cartService.getAllCart());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id")Long id){
        return new ResponseEntity<Cart>(cartService.getCartById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCartById(@PathVariable("id")Long id,
                                                 @RequestBody Cart cart){
        cartService.updateCartById(cart,id);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCartById(@PathVariable("id")Long id){
        cartService.deleteCartById(id);
        return ResponseEntity.ok("");
    }
}
