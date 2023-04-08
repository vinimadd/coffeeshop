package com.example.coffeeshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository theProductRepository) {
        productRepository = theProductRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
