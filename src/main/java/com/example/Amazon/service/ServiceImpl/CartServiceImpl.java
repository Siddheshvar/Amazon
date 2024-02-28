package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Cart;
import com.example.Amazon.repository.CartRepository;
import com.example.Amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCart() {
        return null;
    }

    @Override
    public Cart getCartById(Long id) {
        return null;
    }

    @Override
    public Cart updateCartById(Cart cart, Long id) {
        return null;
    }

    @Override
    public void deleteCartById(Long id) {

    }
}
