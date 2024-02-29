package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.CartItems;
import com.example.Amazon.repository.CartItemRepository;
import com.example.Amazon.service.CartItemService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItems saveCartItem(CartItems cartItems) {
        return cartItemRepository.save(cartItems);
    }

    @Override
    public List<CartItems> getAllCartItem() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItems getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart items not found!"));
    }

    @Override
    public CartItems updateCartItemById(@NotNull CartItems cartItems, Long id) {
        CartItems oldItems = cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart items not found to update!"));

        oldItems.setItemQty(cartItems.getItemQty());

        return cartItemRepository.save(oldItems);
    }

    @Override
    public void deleteCartItemById(Long id) {
        cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart items not found to delete!"));
        cartItemRepository.deleteById(id);
    }
}
