package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.SignUpRequest;
import com.example.Amazon.Response.BaseResponse;
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
    public BaseResponse newSignUp(SignUpRequest signUpRequest) {
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
                return new BaseResponse(200,"New user created",signUp);
            }else{
                return new BaseResponse(404,"Phone number already exists",signUpRequest.getPhoneNo());
            }
        }else {
            return new BaseResponse(404,"Email id already exists",signUpRequest.getEmailId());
        }
    }

    @Override
    public BaseResponse<List<SignUpResponse>> getAllUsers() {
        List<SignUp> list = signUpRepository.findByIsDeleted(false);
        if (!list.isEmpty() && list.size() > 0) {
            List<SignUpResponse> signUpResponseArrayList = new ArrayList<>();
            for (SignUp signUp : list) {
                SignUpResponse signUpResponse = new SignUpResponse();
                signUpResponse.setId(signUp.getId());
                signUpResponse.setFullName(signUp.getFullName());
                signUpResponse.setPhoneNo(signUp.getPhoneNo());
                signUpResponse.setEmailId(signUp.getEmailId());

                signUpResponseArrayList.add(signUpResponse);
            }
            return new BaseResponse<List<SignUpResponse>>(200,"",signUpResponseArrayList);
        }else {
            return new BaseResponse(404,"No users found!",null);
        }
    }


    @Override
    public BaseResponse getUserById(Integer id) {
        Optional<SignUp> user = signUpRepository.findByIsDeletedAndId(false,id);
        if (user.isPresent() && user!=null) {
            SignUpResponse signUpResponse = new SignUpResponse();
            signUpResponse.setId(user.get().getId());
            signUpResponse.setFullName(user.get().getFullName());
            signUpResponse.setPhoneNo(user.get().getPhoneNo());
            signUpResponse.setEmailId(user.get().getEmailId());

            return new BaseResponse(200,"Retrieved user",signUpResponse);
        }else{
            return new BaseResponse(404,"No user found!",null);
        }
    }


    @Override
    public BaseResponse updateUserById(SignUpRequest signUpRequest, Integer id) {
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
                    return new BaseResponse(200,"Updated user",user.get().getFullName());
                }else{
                    return new BaseResponse(404,"Phone number already exists", signUpRequest.getPhoneNo());
                }
            }else{
                return new BaseResponse(404,"Email id already exists", signUpRequest.getEmailId());
            }
        }else {
            return new BaseResponse(404,"No user found!",null);
        }
    }

    @Override
    public BaseResponse deleteUserById(Integer id) {
        Optional<SignUp> user = signUpRepository.findByIsDeletedAndId(false,id);
        if (user.isPresent() && user!=null) {
            signUpRepository.deleteById(id);
            return new BaseResponse(200,"Deleted user",user.get().getFullName());
        }else {
            return new BaseResponse(404,"No user found!",null);
        }
    }
}
