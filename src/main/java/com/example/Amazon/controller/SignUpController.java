package com.example.Amazon.controller;

import com.example.Amazon.Requests.SignUpRequest;
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
    public SignUpResponse newSignUp(@RequestBody SignUpRequest signUpRequest){
        return signUpService.newSignUp(signUpRequest);
    }

    @GetMapping("/getAll")
    public SignUpResponse getAllUsersUp(){
        return signUpService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public SignUpResponse getUserById(@PathVariable("id")Integer id){
        return signUpService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public SignUpResponse updateUserById(@RequestBody SignUpRequest signUpRequest,
                                         @PathVariable("id")Integer id){
        return signUpService.updateUserById(signUpRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public SignUpResponse deleteUserById(@PathVariable("id")Integer id){
        return signUpService.deleteUserById(id);
    }
}
