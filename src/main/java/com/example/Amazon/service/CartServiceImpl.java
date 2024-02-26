package com.example.Amazon.service;

import com.example.Amazon.entity.Cart;
import com.example.Amazon.repository.CartRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart saveCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCart() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getCartById(long id) {
        return this.cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Cart updateCartById(@NotNull Cart cart, long id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        existingCart.setCartItems(cart.getCartItems());

        return this.cartRepository.save(cart);
    }

   @Override
    public void deleteCartById(long id) {
        cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        cartRepository.deleteById(id);
    }

}
