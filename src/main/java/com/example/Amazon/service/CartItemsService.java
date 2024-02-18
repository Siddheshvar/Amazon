package com.example.Amazon.service;

import com.example.Amazon.entity.CartItems;

import java.util.List;

public interface CartItemsService {
    CartItems saveItem(CartItems item);
    List<CartItems> getAllItems();
    CartItems getItemById(long id);
    CartItems updateItemById(CartItems item, long id);
    void deleteItemById(long id);
}

