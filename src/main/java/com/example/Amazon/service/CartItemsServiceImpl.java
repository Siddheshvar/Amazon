package com.example.Amazon.service;

import com.example.Amazon.entity.CartItems;
import com.example.Amazon.repository.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartItemsServiceImpl implements CartItemsService{
    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Override
    public CartItems saveItem(CartItems item) {
        return this.saveItem(item);
    }

    @Override
    public List<CartItems> getAllItems() {
        return this.cartItemsRepository.findAll();
    }

    @Override
    public CartItems getItemById(long id) {
        return this.cartItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public CartItems updateItemById(CartItems item, long id) {
        CartItems existingItem = cartItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        existingItem.setCartItemId(item.getCartItemId());

        return this.cartItemsRepository.save(existingItem);
    }

    @Override
    public void deleteItemById(long id) {
        cartItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        cartItemsRepository.deleteById(id);
    }
}
