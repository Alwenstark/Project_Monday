package com.Project_Monday.controller;


import com.Project_Monday.model.Product;
import com.Project_Monday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("products")
    public String products(Model model) {
        List<Product> productList = service.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @PostMapping("addproduct")
    public String addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @DeleteMapping("deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        return service.deleteProduct(productId);
    }

    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable Long productId){
        return service.getProductById(productId);
    }
}
