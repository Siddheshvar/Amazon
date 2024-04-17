package com.example.Amazon.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private SignUp signUp;

//    @OneToMany(mappedBy = "shippingAddress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Order> orders;



    private Boolean isDeleted;
    private Date createOn;
    private Date updateOn;

}
