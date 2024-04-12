package com.example.Amazon.service;

import com.example.Amazon.Requests.SignUpRequest;
import com.example.Amazon.Response.SignUpResponse;
import com.example.Amazon.entity.SignUp;

import java.util.List;

public interface SignUpService {

    SignUpResponse newSignUp(SignUpRequest signUpRequest);

    SignUpResponse<List<SignUp>> getAllUsers();

    SignUpResponse getUserById(Integer id);

    SignUpResponse updateUserById(SignUpRequest signUpRequest, Integer id);

    SignUpResponse deleteUserById(Integer id);
}
