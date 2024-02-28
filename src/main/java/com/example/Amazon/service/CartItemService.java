package com.example.Amazon.service;

import com.example.Amazon.entity.CartItems;
import java.util.List;

public interface CartItemService {

    CartItems saveCartItem(CartItems cartItems);
    List<CartItems> getAllCartItem();
    CartItems getCartItemById(Long id);
    CartItems updateCartItemById(CartItems cartItems,Long id);
    void deleteCartItemById(Long id);
}
