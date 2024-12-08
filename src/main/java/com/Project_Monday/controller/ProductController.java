package com.Project_Monday.controller;


import com.Project_Monday.model.Product;
import com.Project_Monday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> productList = service.getAllProducts();
        model.addAttribute("products", productList);
        return "product/products"; //-------------------------------------->list of products page
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable("id") Long productID, Model model) {
        Product product = service.getProductById(productID);
        if(product!=null) {
            model.addAttribute("product", product);
            return "product/productview";   //---------------------------------->product page
        } else
            return "Bad Request"; //--------------------------------> bad request page
    }

    @GetMapping("/products/addproduct")
    public String addProductPage(){
        return "product/addProduct";
    }

    @PostMapping("/products/addproduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model ){
        Product product = new Product();
        product.setName(name);
//        product.setSize(size);
        product.setPrice(price);
//        product.setCategory(category);
//        product.setDescription(description);
//        product.setColor(color);
//        product.setImage_url(image_url);

        String response = service.addProduct(product);
        model.addAttribute("message", response); //------->This give message in ui that is added successful or not
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        System.out.println("Delete method called");
        Product product = service.getProductById(productId);
        if(product != null) {
            service.deleteProduct(productId);
            return "redirect:/products";
        } else
            return "Bad Request";
    }

    @GetMapping("/products/updateproduct")
    public String updateProductPage(@RequestParam("id") Long productId, Model model){
        Product product = service.getProductById(productId);
        model.addAttribute("product",product);
        return "product/updateproduct";
    }

    @PostMapping("/products/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") Long productId,
                                @RequestParam String newName,
                                @RequestParam double newPrice){
        service.updateProduct(productId,newName,newPrice);
        return "redirect:/products";
    }
}