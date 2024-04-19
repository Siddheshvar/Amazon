package com.example.Amazon.service;

import com.example.Amazon.Requests.SignUpRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.SignUpResponse;
import com.example.Amazon.entity.SignUp;

import java.util.List;

public interface SignUpService {

    BaseResponse newSignUp(SignUpRequest signUpRequest);

    BaseResponse<List<SignUpResponse>> getAllUsers();

    BaseResponse getUserById(Integer id);

    BaseResponse updateUserById(SignUpRequest signUpRequest, Integer id);

    BaseResponse deleteUserById(Integer id);
}
