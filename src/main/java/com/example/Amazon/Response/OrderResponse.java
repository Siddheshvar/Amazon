package com.example.Amazon.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer id;
    private Date orderDate;
    private Float totalAmount;
    private AddressResponse addressResponse;
    private SignUpResponse signUpResponse;


}
