package com.example.Amazon.service;

import com.example.Amazon.entity.Login;

import java.util.List;

public interface LoginService {

    Login saveLogin(Login login);
    List<Login> getAllLogin();
    Login getLoginById(long id);
    Login updateLoginById(Login login, long id);
    void deleteLoginById(long id);
}
