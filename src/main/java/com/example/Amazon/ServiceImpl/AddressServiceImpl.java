package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Response.AddressResponse;
import com.example.Amazon.entity.Address;
import com.example.Amazon.repository.AddressRepository;
import com.example.Amazon.service.AddressService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        Optional<Address> address = addressRepository.findByIsDeletedAndId(false,id);
        if (address.isPresent()) {
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

        }
        return null;
    }

    @Override
    public Address updateAddressById(@NotNull Address address, Integer id) {
        Address oldAddress = addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... address not found to update!"));

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
                new RuntimeException("Oops... address not found to delete!"));
        addressRepository.deleteById(id);
    }
}
