package com.example.Amazon.Requests;

import com.example.Amazon.entity.SignUp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String flatOrHouseNo;
    private String residencyOrApartment;
    private String areaOrColony;
    private String townOrVillage;
    private String city;
    private String subDistrict;
    private String district;
    private Integer pinCode;
    private String state;
    private String country;
    private Integer signUp;

}
