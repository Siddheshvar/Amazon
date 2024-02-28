package com.example.Amazon.service;

import com.example.Amazon.entity.Address;
import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    List<Address> getAllAddress();
    Address getAddressById(Integer id);
    Address updateAddressById(Address address,Integer id);
    void deleteAddressById(Integer id);
}
