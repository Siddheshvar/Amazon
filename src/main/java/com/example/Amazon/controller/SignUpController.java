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
    public ResponseEntity<String> save(@RequestBody SignUp signUp){
        signUpService.save(signUp);
        return ResponseEntity.ok("You have successfully signed Up!");
    }

    @GetMapping("/getall")
    public List<SignUp> getall(){
        return new ArrayList<SignUp>(signUpService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SignUp> getById(@PathVariable("id")long id){
        return new ResponseEntity<SignUp>(signUpService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@RequestBody SignUp signUp,
                                             @PathVariable("id")long id){
        signUpService.updateById(signUp,id);
        return ResponseEntity.ok("ID "+id+"'s signup details updated! check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id")long id){
        signUpService.deleteById(id);
        return ResponseEntity.ok("Signup details of ID "+id+" are successfully deleted!");
    }
}
