package com.ceetech.onlineshop.service.impl;

import org.springframework.stereotype.Service;

import com.ceetech.onlineshop.repository.ProductRepository;
import com.ceetech.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
}
