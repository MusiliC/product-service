package com.ceetech.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("hello")
    public String getMethodName(@RequestParam(required = false) String params) {
        log.info("Received params {}", params);
        return "Hello world";
    }

}
