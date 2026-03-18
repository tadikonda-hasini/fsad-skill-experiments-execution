package com.klu.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Product1Controller {

    @Autowired
    private Product1Repository product1Repository;

    // Add product
    @PostMapping("/add")
    public Product1 addProduct(@RequestBody Product1 product) {
        return product1Repository.save(product);
    }

    // Get all products
    @GetMapping("/all")
    public List<Product1> getAllProducts() {
        return product1Repository.findAll();
    }
}