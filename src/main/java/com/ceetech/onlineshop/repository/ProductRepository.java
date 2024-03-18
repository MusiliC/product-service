package com.ceetech.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceetech.onlineshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
