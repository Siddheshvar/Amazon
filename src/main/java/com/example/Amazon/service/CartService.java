package com.example.Amazon.service;

import com.example.Amazon.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    Cart saveCart(Cart cart);
    List<Cart> getAllCart();
    Cart getCartById(long id);
    Cart updateCartById(Cart cart, long id);
    void deleteCartById(long id);
}
