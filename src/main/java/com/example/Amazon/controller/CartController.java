package com.example.Amazon.controller;

import com.example.Amazon.Response.BaseResponse;
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
    public BaseResponse saveCart(@RequestBody Cart cart){
        return cartService.saveCart(cart);
    }

    @GetMapping("/getAll")
    public BaseResponse getAllCart(){
        return cartService.getAllCart();
    }

    @GetMapping("/get/{id}")
    public BaseResponse getCartById(@PathVariable("id")Integer id){
        return cartService.getCartById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateCartById(@PathVariable("id")Integer id,
                                                 @RequestBody Cart cart){
        return cartService.updateCartById(cart,id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteCartById(@PathVariable("id")Integer id){
        return cartService.deleteCartById(id);
    }
}
