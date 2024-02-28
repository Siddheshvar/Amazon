package com.example.Amazon.controller;

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
    public ResponseEntity<String> saveAddress(@RequestBody Address address){
        addressService.saveAddress(address);
        return ResponseEntity.ok("Address is saved!");
    }

    @GetMapping("/getall")
    public List<Address> getAllAddresses(){
        return new ArrayList<Address>(addressService.getAllAddress());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id){
        return new ResponseEntity<Address>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddressById(@RequestBody Address address,
                                                    @PathVariable("id")Integer id){
        addressService.updateAddressById(address,id);
        return ResponseEntity.ok("Address of id no "+id+" is updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable("id")Integer id){
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("Address od id no "+id+"  is deleted!");
    }
}
