package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Address;
import com.example.Amazon.repository.AddressRepository;
import com.example.Amazon.service.AddressService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
    }

    @Override
    public Address updateAddressById(@NotNull Address address, Integer id) {
        Address oldAddress = addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));

        oldAddress.setFlatOrHouseNo(address.getFlatOrHouseNo());
        oldAddress.setResidencyOrApartment(address.getResidencyOrApartment());
        oldAddress.setAreaOrColony(address.getAreaOrColony());
        oldAddress.setTownOrVillage(address.getTownOrVillage());
        oldAddress.setCity(address.getCity());
        oldAddress.setSubDistrict(address.getSubDistrict());
        oldAddress.setDistrict(address.getDistrict());
        oldAddress.setPinCode(address.getPinCode());
        oldAddress.setState(address.getState());
        oldAddress.setCountry(address.getCountry());

        return addressRepository.save(oldAddress);
    }

    @Override
    public void deleteAddressById(Integer id) {
        addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
        addressRepository.deleteById(id);
    }
}
