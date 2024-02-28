package com.example.Amazon.service;

import com.example.Amazon.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveSignUp(Customer customer);
    List<Customer> getAllSignUps();
    Customer getSignUpById(long id);
    Customer updateSignUpById(Customer customer, long id);
    void deleteSignUpById(long id);
}
