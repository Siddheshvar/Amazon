package com.example.Amazon.Response;

import com.example.Amazon.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {
    private Integer id;
    private String fullName;
    private String phoneNo;
    private String emailId;
//    private List<Order> orders;

}
