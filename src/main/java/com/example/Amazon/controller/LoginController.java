package com.example.Amazon.controller;

import com.example.Amazon.entity.Login;
import com.example.Amazon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/save")
    public ResponseEntity<String>save(@RequestBody Login login){
        loginService.save(login);
        return ResponseEntity.ok("You have successfully logged in!");
    }

    @GetMapping("/getall")
    public List<Login> getAll(){
        return new ArrayList<Login>(loginService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Login>getById(@PathVariable("id")long id){
        return new ResponseEntity<Login>(loginService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>updateById(@RequestBody Login login,
                                            @PathVariable("id")long id){
        Login oldLogin = loginService.updateById(login,id);
        return ResponseEntity.ok("ID "+id+"'s login details updated! check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteById(@PathVariable("id")long id){
        loginService.deleteById(id);
        return ResponseEntity.ok("Login details of ID "+id+" are successfully deleted!");
    }
}
