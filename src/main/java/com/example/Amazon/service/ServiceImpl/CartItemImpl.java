package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.CartItems;
import com.example.Amazon.repository.CartItemRepository;
import com.example.Amazon.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItems saveCartItem(CartItems cartItems) {
        return null;
    }

    @Override
    public List<CartItems> getAllCartItem() {
        return null;
    }

    @Override
    public CartItems getCartItemById(Long id) {
        return null;
    }

    @Override
    public CartItems updateCartItemById(CartItems cartItems, Long id) {
        return null;
    }

    @Override
    public void deleteCartItemById(Long id) {

    }
}
