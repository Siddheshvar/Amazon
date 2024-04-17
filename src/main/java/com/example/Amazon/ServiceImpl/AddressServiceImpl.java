package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Response.AddressResponse;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.entity.Address;
import com.example.Amazon.repository.AddressRepository;
import com.example.Amazon.service.AddressService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public BaseResponse saveAddress(AddressResponse addressResponse) {
        Address address = new Address();
        address.setFlatOrHouseNo(addressResponse.getFlatOrHouseNo());
        address.setResidencyOrApartment(addressResponse.getResidencyOrApartment());
        address.setAreaOrColony(addressResponse.getAreaOrColony());
        address.setTownOrVillage(addressResponse.getTownOrVillage());
        address.setCity(addressResponse.getCity());
        address.setSubDistrict(addressResponse.getSubDistrict());
        address.setDistrict(addressResponse.getDistrict());
        address.setPinCode(addressResponse.getPinCode());
        address.setState(addressResponse.getState());
        address.setCountry(addressResponse.getCountry());
        address.setIsDeleted(false);
        address.setCreateOn(new Date());

        addressRepository.save(address);
        return new BaseResponse(200,"New Address Added!",address);
    }

    @Override
    public BaseResponse<List<AddressResponse>> getAllAddress() {
        List<Address> address = addressRepository.findByIsDeleted(false);
        if (!address.isEmpty() && address.size() > 0) {
            List<AddressResponse> addressArrayList = new ArrayList<>();
            for (Address address1 : address) {
                AddressResponse addressResponse = new AddressResponse();
                addressResponse.setId(address1.getId());
                addressResponse.setFlatOrHouseNo(address1.getFlatOrHouseNo());
                addressResponse.setResidencyOrApartment(address1.getResidencyOrApartment());
                addressResponse.setAreaOrColony(address1.getAreaOrColony());
                addressResponse.setTownOrVillage(address1.getTownOrVillage());
                addressResponse.setCity(address1.getCity());
                addressResponse.setSubDistrict(address1.getSubDistrict());
                addressResponse.setDistrict(address1.getDistrict());
                addressResponse.setPinCode(address1.getPinCode());
                addressResponse.setState(address1.getState());
                addressResponse.setCountry(address1.getCountry());

                addressArrayList.add(addressResponse);
            }
            return new BaseResponse<>(200,"All Address Added!",addressArrayList);
        }else{
            return new BaseResponse<>(404,"No Address Found!",null);
        }
    }

    @Override
    public BaseResponse getAddressById(Integer id) {
        Optional<Address> address = addressRepository.findByIsDeletedAndId(false,id);
        if (address.isPresent() && address!=null) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setId(address.get().getId());
            addressResponse.setFlatOrHouseNo(address.get().getFlatOrHouseNo());
            addressResponse.setResidencyOrApartment(address.get().getResidencyOrApartment());
            addressResponse.setAreaOrColony(address.get().getAreaOrColony());
            addressResponse.setTownOrVillage(address.get().getTownOrVillage());
            addressResponse.setCity(address.get().getCity());
            addressResponse.setSubDistrict(address.get().getSubDistrict());
            addressResponse.setDistrict(address.get().getDistrict());
            addressResponse.setPinCode(address.get().getPinCode());
            addressResponse.setState(address.get().getState());
            addressResponse.setCountry(address.get().getCountry());

            return new BaseResponse(200,"Retrieved Address",addressResponse);
        }else {
            return new BaseResponse(404,"No Address Found!",null);
        }
    }

    @Override
    public BaseResponse updateAddressById(@NotNull AddressResponse addressResponse, Integer id) {
        Optional<Address> address = addressRepository.findByIsDeletedAndId(false,id);
        if (address.isPresent() && address!=null) {
            address.get().setFlatOrHouseNo(addressResponse.getFlatOrHouseNo());
            address.get().setResidencyOrApartment(addressResponse.getResidencyOrApartment());
            address.get().setAreaOrColony(addressResponse.getAreaOrColony());
            address.get().setTownOrVillage(addressResponse.getTownOrVillage());
            address.get().setCity(addressResponse.getCity());
            address.get().setSubDistrict(addressResponse.getSubDistrict());
            address.get().setDistrict(addressResponse.getDistrict());
            address.get().setPinCode(addressResponse.getPinCode());
            address.get().setState(addressResponse.getState());
            address.get().setCountry(addressResponse.getCountry());

            return new BaseResponse(200,"Updated Address",address.get());
        }else{
            return new BaseResponse(404,"Oops... address not found to update!",null);
        }
    }

    @Override
    public BaseResponse deleteAddressById(Integer id) {
        Optional<Address> address = addressRepository.findByIsDeletedAndId(false,id);
        if (address.isPresent() && address!=null){
            addressRepository.deleteById(id);
            return new BaseResponse(200,"Address deleted successfully",null);
        }else{
            return new BaseResponse(404,"Oops... address not found to delete!",null);
        }
    }
}
