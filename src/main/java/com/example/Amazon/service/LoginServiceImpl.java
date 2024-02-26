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
    public Login saveLogin(Login login) {
        return this.loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogin() {
        return this.loginRepository.findAll();
    }

    @Override
    public Login getLoginById(long id) {
        return this.loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Login updateLoginById(@NotNull Login login, long id) {
        Login oldLogin = loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        oldLogin.setEmailId(login.getEmailId());
        oldLogin.setPassword(login.getPassword());

        return this.loginRepository.save(oldLogin);
    }

    @Override
    public void deleteLoginById(long id) {
        loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        loginRepository.deleteById(id);
    }
}
