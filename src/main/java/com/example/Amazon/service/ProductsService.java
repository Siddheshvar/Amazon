package com.example.Amazon.service;

import com.example.Amazon.Requests.ProductRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.ProductResponse;

import java.util.List;

public interface ProductsService {
    BaseResponse saveProduct(ProductRequest productRequest);
    BaseResponse<List<ProductResponse>> getAllProducts();
    BaseResponse getProductById(Integer id);
    BaseResponse updateProductById(ProductRequest productRequest, Integer id);
    BaseResponse deleteProductById(Integer id);
    BaseResponse<List<ProductResponse>> getAllProductsByCategory(String category);
}
