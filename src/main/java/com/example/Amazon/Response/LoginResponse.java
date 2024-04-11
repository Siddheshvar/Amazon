package com.example.Amazon.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse<T> {

    private Integer status;
    private String message;
    private T data;
}
