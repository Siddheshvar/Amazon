package com.example.Amazon.service;

import com.example.Amazon.entity.Cart;
import com.example.Amazon.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart save(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getById(long id) {
        return this.cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Cart updateById(Cart cart, long id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        existingCart.setCartItems(cart.getCartItems());

        return this.cartRepository.save(cart);
    }

   @Override
    public void deleteById(long id) {
        cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        cartRepository.deleteById(id);
    }

}
