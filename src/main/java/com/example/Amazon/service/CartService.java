package com.example.Amazon.service;

import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Cart;
import java.util.List;

public interface CartService {
    BaseResponse saveCart(Cart cart);
    BaseResponse<List<Cart>> getAllCart();
    BaseResponse getCartById(Integer id);
    BaseResponse updateCartById(Cart cart, Integer id);
    BaseResponse deleteCartById(Integer id);

}
