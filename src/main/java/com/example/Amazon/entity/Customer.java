package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "customer")
public class    Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phoneNo;
    private String emailId;
    private String createPass;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Order> orders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Address> addresses;


}
