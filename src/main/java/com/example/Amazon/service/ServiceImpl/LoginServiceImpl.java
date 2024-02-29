package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Login;
import com.example.Amazon.repository.LoginRepository;
import com.example.Amazon.service.LoginService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogin() {
        return loginRepository.findAll();
    }

    @Override
    public Login getLoginById(long id) {
        return loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... login details not found!"));
    }

    @Override
    public Login updateLoginById(@NotNull Login login, long id) {
        Login oldLogin = loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... login details not found to update!"));

        oldLogin.setEmailId(login.getEmailId());
        oldLogin.setPassword(login.getPassword());

        return loginRepository.save(oldLogin);
    }

    @Override
    public void deleteLoginById(long id) {
        loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... login details not found to delete!"));
        loginRepository.deleteById(id);
    }
}
