package com.example.Amazon.controller;

import com.example.Amazon.Requests.SignUpRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.SignUpResponse;
import com.example.Amazon.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PostMapping("/save")
    public BaseResponse newSignUp(@RequestBody SignUpRequest signUpRequest){
        return signUpService.newSignUp(signUpRequest);
    }

    @GetMapping("/getAll")
    public BaseResponse getAllUsersUp(){
        return signUpService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public BaseResponse getUserById(@PathVariable("id")Integer id){
        return signUpService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateUserById(@RequestBody SignUpRequest signUpRequest,
                                         @PathVariable("id")Integer id){
        return signUpService.updateUserById(signUpRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteUserById(@PathVariable("id")Integer id){
        return signUpService.deleteUserById(id);
    }
}
