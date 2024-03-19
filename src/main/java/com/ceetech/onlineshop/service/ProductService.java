package com.ceetech.onlineshop.service;

import java.util.List;

import com.ceetech.onlineshop.model.ProductCreateRequest;
import com.ceetech.onlineshop.model.ProductCreateResponse;

public interface ProductService {

    ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest);

    List<ProductCreateResponse> findAll();
    
}
