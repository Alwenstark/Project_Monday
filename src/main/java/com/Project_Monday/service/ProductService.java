package com.Project_Monday.service;

import com.Project_Monday.model.Product;
import com.Project_Monday.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(Long productId){
        return repo.findById(productId).orElse(null);
    }

    public String addProduct(Product product){
        try {
            repo.save(product);
            return "Product added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while adding the product.";
        }
    }

    public void deleteProduct(Long productId){
        repo.deleteById(productId);
    }

}
