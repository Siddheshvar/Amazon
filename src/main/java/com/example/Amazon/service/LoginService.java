package com.example.Amazon.service;

import com.example.Amazon.entity.Login;

import java.util.List;

public interface LoginService {

    Login save(Login login);
    List<Login> getAll();
    Login getById(long id);
    Login updateById(Login login,long id);
    void deleteById(long id);
}
