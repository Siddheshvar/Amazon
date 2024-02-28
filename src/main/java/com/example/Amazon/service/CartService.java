package com.example.Amazon.service;

import com.example.Amazon.entity.Cart;
import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart);
    List<Cart> getAllCart();
    Cart getCartById(Long id);
    Cart updateCartById(Cart cart, Long id);
    void deleteCartById(Long id);

}
