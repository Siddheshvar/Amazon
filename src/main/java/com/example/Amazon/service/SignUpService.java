package com.example.Amazon.service;

import com.example.Amazon.entity.SignUp;

import java.util.List;

public interface SignUpService {
    SignUp saveSignUp(SignUp signUp);
    List<SignUp> getAllSignUps();
    SignUp getSignUpById(long id);
    SignUp updateSignUpById(SignUp signUp, long id);
    void deleteSignUpById(long id);
}
