package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.ProductRequest;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.CategoryResponse;
import com.example.Amazon.Response.ProductResponse;
import com.example.Amazon.entity.Product;
import com.example.Amazon.repository.CategoryRepository;
import com.example.Amazon.repository.ProductsRepository;
import com.example.Amazon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public BaseResponse saveProduct(ProductRequest productRequest) {
        Optional<Product> product = productsRepository.findByIsDeletedAndProductNameAndBrand(false,productRequest.getProductName(),productRequest.getBrand());
        if(!product.isPresent()) {
            Product product1 = new Product();
            product1.setProductName(productRequest.getProductName());
            product1.setBrand(productRequest.getBrand());
            product1.setProductDescription(productRequest.getProductDescription());
            product1.setProductPrice(productRequest.getProductPrice());
            product1.setCategory(categoryRepository.findByIsDeletedAndId(false,productRequest.getCategory()).get());
            product1.setCreateOn(new Date());
            product1.setIsDeleted(false);

            productsRepository.save(product1);
            return new BaseResponse(200, "Product saved successfully", product1.getProductName());
        }else{
            return new BaseResponse(404, "Product already exists", product.get().getProductName());
        }
    }

    @Override
    public BaseResponse<List<ProductResponse>> getAllProducts() {
        List<Product> productList = productsRepository.findAll();
        if (!productList.isEmpty() && productList.size() > 0) {
            List<ProductResponse> productResponseArrayList = new ArrayList<>();
            for (Product product1 : productList) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(product1.getId());
                productResponse.setProductName(product1.getProductName());
                productResponse.setBrand(product1.getBrand());
                productResponse.setProductDescription(product1.getProductDescription());
                productResponse.setProductPrice(product1.getProductPrice());

                CategoryResponse categoryResponse = new CategoryResponse();
                categoryResponse.setId(product1.getCategory().getId());
                categoryResponse.setCategoryName(product1.getCategory().getCategoryName());
                categoryResponse.setCategoryDescription(product1.getCategory().getCategoryDescription());

                productResponse.setCategoryResponse(categoryResponse);
                productResponseArrayList.add(productResponse);
            }
            return new BaseResponse(200, "Products retrieved successfully", productResponseArrayList);
        }else {
            return new BaseResponse(404, "No products found", null);
        }
    }

    @Override
    public BaseResponse getProductById(Integer id) {
        Optional<Product> product = productsRepository.findByIsDeletedAndId(false,id);
        if (product.isPresent() && product!=null){
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.get().getId());
            productResponse.setProductName(product.get().getProductName());
            productResponse.setBrand(product.get().getBrand());
            productResponse.setProductDescription(product.get().getProductDescription());
            productResponse.setProductPrice(product.get().getProductPrice());
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(product.get().getCategory().getId());
            categoryResponse.setCategoryName(product.get().getCategory().getCategoryName());
            categoryResponse.setCategoryDescription(product.get().getCategory().getCategoryDescription());

            productResponse.setCategoryResponse(categoryResponse);
            return new BaseResponse(200, "Product retrieved successfully",productResponse);
        }else {
            return new BaseResponse(404, "No product found", null);
        }
    }

    @Override
    public BaseResponse updateProductById(ProductRequest productRequest, Integer id) {
        Optional<Product> product = productsRepository.findByIsDeletedAndId(false,id);
        if (product.isPresent() && product!=null){
            Optional<Product> productName =  productsRepository.findByIsDeletedAndProductNameAndBrand(false,product.get().getProductName(),productRequest.getBrand());
            if(!productName.isPresent()){
                product.get().setProductName(productRequest.getProductName());
                product.get().setBrand(productRequest.getBrand());
                product.get().setProductDescription(productRequest.getProductDescription());
                product.get().setProductPrice(productRequest.getProductPrice());
                product.get().setIsDeleted(false);
                product.get().setUpdateOn(new Date());
                productsRepository.save(product.get());
                return new BaseResponse(200, "Product updated successfully", product.get().getProductName());
            }else{
                return new BaseResponse(404, "Product already exists", productName.get().getProductName());
            }
        }else{
            return new BaseResponse(404, "No such product exists", null);
        }
    }

    @Override
    public BaseResponse deleteProductById(Integer id) {
        Optional<Product> product = productsRepository.findByIsDeletedAndId(false,id);
        if (product.isPresent()) {
            productsRepository.deleteById(id);
            return new BaseResponse(200, "Product deleted successfully", product.get().getProductName());
        }else {
            return new BaseResponse(404, "No such product exists", null);
        }
    }

    @Override
    public BaseResponse<List<ProductResponse>> getAllProductsByCategory(String category) {
        List<Product> productsList = productsRepository.findByIsDeletedAndCategoryCategoryName(false, category);
        List<ProductResponse> productResponseList = new ArrayList<>();
            if (!productsList.isEmpty() && productsList.size() > 0) {
                for (Product product : productsList) {
                    ProductResponse productResponse = new ProductResponse();
                    productResponse.setProductName(product.getProductName());
                    productResponse.setBrand(product.getBrand());
                    productResponse.setProductDescription(product.getProductDescription());
                    productResponse.setProductPrice(product.getProductPrice());

                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setCategoryName(product.getCategory().getCategoryName());
                    categoryResponse.setCategoryDescription(product.getCategory().getCategoryDescription());
                    productResponse.setCategoryResponse(categoryResponse);

                    productResponse.setCategoryResponse(categoryResponse);
                    productResponseList.add(productResponse);
                }
                return new BaseResponse(200, "Products retrieved successfully", productResponseList);
            }else {
                return new BaseResponse(404, "No products found in this category!", null);
            }
    }


}
