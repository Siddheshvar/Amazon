package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Response.BaseResponse;
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
    public BaseResponse saveCart(Cart cart) {
        return null;
    }

    @Override
    public BaseResponse<List<Cart>> getAllCart() {
        return null;
    }

    @Override
    public BaseResponse getCartById(Integer id) {
        return null;
    }

    @Override
    public BaseResponse updateCartById(Cart cart, Integer id) {
        return null;
    }

    @Override
    public BaseResponse deleteCartById(Integer id) {
        return null;
    }
}
