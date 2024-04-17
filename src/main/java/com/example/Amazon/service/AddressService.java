package com.example.Amazon.service;

import com.example.Amazon.Response.AddressResponse;
import com.example.Amazon.Response.BaseResponse;

import java.util.List;

public interface AddressService {
    BaseResponse saveAddress(AddressResponse addressResponse);
    BaseResponse<List<AddressResponse>> getAllAddress();
    BaseResponse getAddressById(Integer id);
    BaseResponse updateAddressById(AddressResponse addressResponse,Integer id);
    BaseResponse deleteAddressById(Integer id);
}
