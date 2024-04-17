package com.example.Amazon.controller;

import com.example.Amazon.Response.AddressResponse;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Address;
import com.example.Amazon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public BaseResponse saveAddress(@RequestBody AddressResponse addressResponse){
        return addressService.saveAddress(addressResponse);
    }

    @GetMapping("/getall")
    public BaseResponse getAllAddresses(){
        return addressService.getAllAddress();
    }

    @GetMapping("/get/{id}")
    public BaseResponse getAddressById(@PathVariable("id") Integer id){
        return addressService.getAddressById(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateAddressById(@RequestBody AddressResponse address,
                                                    @PathVariable("id")Integer id){
        return addressService.updateAddressById(address,id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteAddressById(@PathVariable("id")Integer id){
        return addressService.deleteAddressById(id);
    }
}
