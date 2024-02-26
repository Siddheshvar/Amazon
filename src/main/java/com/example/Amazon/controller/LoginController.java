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
    public ResponseEntity<String> saveLogin(@RequestBody Login login){
        loginService.saveLogin(login);
        return ResponseEntity.ok("You're logged in successfully!");
    }

    @GetMapping("/getall")
    public List<Login> getAllLogin(){
        return new ArrayList<Login>(loginService.getAllLogin());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable("id")long id){
        return new ResponseEntity<Login>(loginService.getLoginById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLoginById(@RequestBody Login login,
                                                  @PathVariable("id")long id){
        Login oldLogin = loginService.updateLoginById(login,id);
        return ResponseEntity.ok("ID "+id+"'s login details are updated! please check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLoginById(@PathVariable("id")long id){
        loginService.deleteLoginById(id);
        return ResponseEntity.ok("Login details of ID "+id+" are successfully deleted!");
    }
}
