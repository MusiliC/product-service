package com.ceetech.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ceetech.onlineshop.entity.Product;
import com.ceetech.onlineshop.model.ProductCreateRequest;
import com.ceetech.onlineshop.model.ProductCreateResponse;
import com.ceetech.onlineshop.repository.ProductRepository;
import com.ceetech.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest) {
        var savedProd = productRepository.save(mapToProductEntity(productCreateRequest));
        return mapToProductCreateResponse(savedProd);
    }

    private Product mapToProductEntity(ProductCreateRequest source) {
        Product target = new Product();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    private ProductCreateResponse mapToProductCreateResponse(Product source) {
        ProductCreateResponse target = new ProductCreateResponse();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Override
    public List<ProductCreateResponse> findAll() {
        return productRepository.findAll().stream().map(this::mapToProductCreateResponse).toList();
    }

}
