package com.example.Amazon.service;

import com.example.Amazon.entity.Login;
import com.example.Amazon.repository.LoginRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login save(Login login) {
        return this.loginRepository.save(login);
    }

    @Override
    public List<Login> getAll() {
        return this.loginRepository.findAll();
    }

    @Override
    public Login getById(long id) {
        return this.loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Login updateById(@NotNull Login login, long id) {
        Login oldLogin = loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        oldLogin.setEmailId(login.getEmailId());
        oldLogin.setPassword(login.getPassword());

        return this.loginRepository.save(oldLogin);
    }

    @Override
    public void deleteById(long id) {
        loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        loginRepository.deleteById(id);
    }
}
