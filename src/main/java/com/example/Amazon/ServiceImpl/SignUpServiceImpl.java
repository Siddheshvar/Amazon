package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.SignUpRequest;
import com.example.Amazon.Response.SignUpResponse;
import com.example.Amazon.entity.SignUp;
import com.example.Amazon.repository.SignUpRepository;
import com.example.Amazon.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponse newSignUp(SignUpRequest signUpRequest) {
        Optional<SignUp> cEmail = signUpRepository.findByIsDeletedAndEmailId(false,signUpRequest.getEmailId());
        if (!cEmail.isPresent()) {
            Optional<SignUp> cPhone = signUpRepository.findByIsDeletedAndPhoneNo(false,signUpRequest.getPhoneNo());
            if (!cPhone.isPresent()) {
                SignUp signUp = new SignUp();
                signUp.setFullName(signUpRequest.getFullName());
                signUp.setPhoneNo(signUpRequest.getPhoneNo());
                signUp.setEmailId(signUpRequest.getEmailId());
                signUp.setCreatePass(passwordEncoder.encode(signUpRequest.getCreatePass()));
                signUp.setIsDeleted(false);
                signUp.setCreateOn(new Date());
                signUpRepository.save(signUp);
                return new SignUpResponse(200,"New user created",signUpRequest.getFullName());
            }else{
                return new SignUpResponse(404,"Phone number already exists",signUpRequest.getPhoneNo());
            }
        }else {
            return new SignUpResponse(404,"Email id already exists",signUpRequest.getEmailId());
        }
    }

    @Override
    public SignUpResponse<List<SignUp>> getAllUsers() {
        List<SignUp> list = signUpRepository.findAll();
        if (!list.isEmpty() && list != null) {
            return new SignUpResponse<List<SignUp>>(200,"",list);
        }else {
            return new SignUpResponse(404,"No user found!",null);
        }
    }


    @Override
    public SignUpResponse getUserById(Integer id) {
        Optional<SignUp> user = signUpRepository.findByIsDeletedAndId(false,id);
        if (user.isPresent() && user!=null) {
            return new SignUpResponse(200,"Retrieved user",user.get());
        }else{
            return new SignUpResponse(404,"No user found!",null);
        }
    }


    @Override
    public SignUpResponse updateUserById(SignUpRequest signUpRequest, Integer id) {
        Optional<SignUp> user = signUpRepository.findByIsDeletedAndId(false,id);
        if (user.isPresent() && user!=null){
            Optional<SignUp> eUser = signUpRepository.findByIsDeletedAndEmailId(false, signUpRequest.getEmailId());
            if (!eUser.isPresent()){
                Optional<SignUp> pSignUp = signUpRepository.findByIsDeletedAndPhoneNo(false, signUpRequest.getPhoneNo());
                if (!pSignUp.isPresent()){
                    user.get().setFullName(signUpRequest.getFullName());
                    user.get().setPhoneNo(signUpRequest.getPhoneNo());
                    user.get().setEmailId(signUpRequest.getEmailId());
                    user.get().setCreatePass(passwordEncoder.encode(signUpRequest.getCreatePass()));

                    user.get().setIsDeleted(false);
                    user.get().setUpdateOn(new Date());
                    signUpRepository.save(user.get());
                    return new SignUpResponse(200,"Updated user",user.get().getFullName());
                }else{
                    return new SignUpResponse(404,"Phone number already exists", signUpRequest.getPhoneNo());
                }
            }else{
                return new SignUpResponse(404,"Email id already exists", signUpRequest.getEmailId());
            }
        }else {
            return new SignUpResponse(404,"No user found!",null);
        }
    }

    @Override
    public SignUpResponse deleteUserById(Integer id) {
        Optional<SignUp> user = signUpRepository.findByIsDeletedAndId(false,id);
        if (user.isPresent() && user!=null) {
            signUpRepository.deleteById(id);
            return new SignUpResponse(200,"Deleted user",user.get().getFullName());
        }else {
            return new SignUpResponse(404,"No user found!",null);
        }
    }
}
