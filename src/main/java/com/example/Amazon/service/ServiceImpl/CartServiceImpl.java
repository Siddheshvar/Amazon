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
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart not found!"));
    }

    @Override
    public Cart updateCartById(Cart cart, Long id) {
        Cart oldCart = cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart not found to update!"));

        return null;
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... cart items not found to delete!"));
        cartRepository.deleteById(id);
    }
}
