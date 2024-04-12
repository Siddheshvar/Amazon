package com.example.Amazon.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "customer")
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNo;

    @NotBlank(message = "Email ID is required")
    @Email(message = "Invalid email format")
    private String emailId;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String createPass;

    @OneToMany(mappedBy = "signUp")
    List<Order> orders;

    @OneToMany(mappedBy = "signUp")
    private List<Address> address;

    private Boolean isDeleted;
    private Date createOn;
    private Date updateOn;

}
