package com.example.Amazon.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Integer id;
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
//    private SignUpResponse signUpResponse;

}
