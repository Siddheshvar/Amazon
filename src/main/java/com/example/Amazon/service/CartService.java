package com.example.Amazon.service;

import com.example.Amazon.entity.Cart;

import java.util.List;

public interface CartService {

    Cart save(Cart cart);
    List<Cart> getAll();
    Cart getById(long id);
    Cart updateById(Cart cart, long id);
    void deleteById(long id);
}
