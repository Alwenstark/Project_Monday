package com.Project_Monday.controller;


import com.Project_Monday.model.Product;
import com.Project_Monday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String login()
    {
        return "Welcome";
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable int productId){
        return service.getProductById(productId);
    }
}
