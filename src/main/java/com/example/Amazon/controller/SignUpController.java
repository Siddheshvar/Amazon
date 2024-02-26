package com.example.Amazon.controller;

import com.example.Amazon.entity.SignUp;
import com.example.Amazon.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSignUp(@RequestBody SignUp signUp){
        signUpService.saveSignUp(signUp);
        return ResponseEntity.ok("You have successfully signed Up!");
    }

    @GetMapping("/getall")
    public List<SignUp> getAllSignUp(){
        return new ArrayList<SignUp>(signUpService.getAllSignUps());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SignUp> getSignUpById(@PathVariable("id")long id){
        return new ResponseEntity<SignUp>(signUpService.getSignUpById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSignUpById(@RequestBody SignUp signUp,
                                                   @PathVariable("id")long id){
        signUpService.updateSignUpById(signUp,id);
        return ResponseEntity.ok("ID "+id+"'s signup details are updated! please check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSignUpById(@PathVariable("id")long id){
        signUpService.deleteSignUpById(id);
        return ResponseEntity.ok("Signup details of ID "+id+" are successfully deleted!");
    }
}
