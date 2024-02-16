package com.example.Amazon.service;

import com.example.Amazon.entity.SignUp;

import java.util.List;

public interface SignUpService {
    SignUp save(SignUp signUp);
    List<SignUp> getAll();
    SignUp getById(long id);
    SignUp updateById(SignUp signUp,long id);
    void deleteById(long id);
}
