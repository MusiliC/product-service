package com.ceetech.onlineshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceetech.onlineshop.model.GenericResponseApi;
import com.ceetech.onlineshop.model.ProductCreateRequest;
import com.ceetech.onlineshop.model.ProductCreateResponse;
import com.ceetech.onlineshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("api/products")
@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public  GenericResponseApi<List<ProductCreateResponse>> listProducts() {
        List<ProductCreateResponse> pr = productService.findAll();
        GenericResponseApi<List<ProductCreateResponse>> resp = GenericResponseApi.<List<ProductCreateResponse>>builder()
                 .success(true)
                 .msg("Data fetched Successfully")
                 .data(pr)
                 .build();
                 log.info("We returned : {}",pr);
                 return resp;
    }

    @PostMapping
    public GenericResponseApi<ProductCreateResponse> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        log.info("We received : {}", productCreateRequest);

        ProductCreateResponse pr = productService.createProduct(productCreateRequest);
        GenericResponseApi<ProductCreateResponse> resp = GenericResponseApi.<ProductCreateResponse>builder()
                .success(true)
                .msg("Successfully created")
                .data(pr)
                .build();

        log.info("We returned : {}", pr);
        return resp;
    }

}
