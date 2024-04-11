package com.example.Amazon.service;

import com.example.Amazon.Requests.LoginRequest;
import com.example.Amazon.Response.LoginResponse;

public interface LoginService {
    LoginResponse authenticateUser(LoginRequest loginRequest);
}
