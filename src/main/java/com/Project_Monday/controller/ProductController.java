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
    public String getProducts(Model model) {
        List<Product> productList = service.getAllProducts();
        model.addAttribute("products", productList);
        return "products"; //-------------------------------------->list of products page
    }

    @GetMapping("products/{id}")
    public String getProduct(@PathVariable("id") Long productID, Model model) {
        Product product = service.getProductById(productID);
        if(product!=null) {
            model.addAttribute("product", product);
            return "product";   //---------------------------------->product page
        } else
            return "Bad Request"; //--------------------------------> bad request page
    }

    @PostMapping("addproduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String size,
                             @RequestParam double price,
                             @RequestParam String category,
                             @RequestParam String description,
                             @RequestParam String color,
                             @RequestParam String image_url,
                             Model model ){
        Product product = new Product();
        product.setName(name);
        product.setSize(size);
        product.setPrice(price);
        product.setCategory(category);
        product.setDescription(description);
        product.setColor(color);
        product.setImage_url(image_url);

        String response = service.addProduct(product);
        model.addAttribute("message", response); //------->This give message in ui that is added successful or not
        return "redirect:/products";
    }

    @DeleteMapping("deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        Product product = service.getProductById(productId);
        if(product!=null) {
            service.deleteProduct(productId);
            return "redirect:/products";
        } else
            return "Bad Request";
    }

}
