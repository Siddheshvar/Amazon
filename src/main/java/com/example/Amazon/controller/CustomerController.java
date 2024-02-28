package com.example.Amazon.controller;

import com.example.Amazon.entity.Customer;
import com.example.Amazon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/signup")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSignUp(@RequestBody Customer customer){
        customerService.saveSignUp(customer);
        return ResponseEntity.ok("You have successfully signed Up!");
    }

    @GetMapping("/getall")
    public List<Customer> getAllSignUp(){
        return new ArrayList<Customer>(customerService.getAllSignUps());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getSignUpById(@PathVariable("id")long id){
        return new ResponseEntity<Customer>(customerService.getSignUpById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSignUpById(@RequestBody Customer customer,
                                                   @PathVariable("id")long id){
        customerService.updateSignUpById(customer,id);
        return ResponseEntity.ok("ID "+id+"'s signup details are updated! please check in DB");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSignUpById(@PathVariable("id")long id){
        customerService.deleteSignUpById(id);
        return ResponseEntity.ok("Signup details of ID "+id+" are successfully deleted!");
    }
}
