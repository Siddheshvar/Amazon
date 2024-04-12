package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.LoginRequest;
import com.example.Amazon.Response.LoginResponse;
import com.example.Amazon.entity.SignUp;
import com.example.Amazon.repository.SignUpRepository;
import com.example.Amazon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Optional<SignUp> customer = signUpRepository.findByIsDeletedAndEmailId(false, loginRequest.getEmailId());
        if (customer.isPresent() && customer!=null) {
            Boolean email = customer.get().getEmailId().equals(loginRequest.getEmailId());

            Boolean password = passwordEncoder.matches(loginRequest.getPassword(),customer.get().getCreatePass());
            if (email && password){
                return new LoginResponse(200,"You are logged in successfully",null);
            }   else{
                return new LoginResponse(404,"Invalid email or password",null);
            }
        }   else{
            return new LoginResponse(404,"User does not exist",null);
        }
    }
}
