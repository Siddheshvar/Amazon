package com.example.Amazon.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_Id")
    private Integer addressId;

    private String flatOrHouseNo;
    private String residencyOrApartment;
    private String areaOrColony;
    private String townOrVillage;
    private String city;
    private String subDistrict;
    private String District;
    private Integer pinCode;
    private String state;
    private String country;

//    @ManyToOne
//    @JoinColumn(name = "customer_Id",nullable = false)
//    private Customer customer;

}
