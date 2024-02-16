package com.example.Amazon.service;

import com.example.Amazon.entity.SignUp;
import com.example.Amazon.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService{
    @Autowired
    private SignUpRepository signUpRepository;

    @Override
    public SignUp save(SignUp signUp) {
        return this.signUpRepository.save(signUp);
    }

    @Override
    public List<SignUp> getAll() {
        return this.signUpRepository.findAll();
    }

    @Override
    public SignUp getById(long id) {
        return this.signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public SignUp updateById(SignUp signUp, long id) {
        SignUp oldSignUp = signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        oldSignUp.setFullName(oldSignUp.getFullName());
        oldSignUp.setPhoneNo(signUp.getPhoneNo());
        oldSignUp.setEmailId(signUp.getEmailId());
        oldSignUp.setCreatePass(signUp.getCreatePass());

        return this.signUpRepository.save(oldSignUp);
    }

    @Override
    public void deleteById(long id) {
        signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        signUpRepository.deleteById(id);
    }
}
