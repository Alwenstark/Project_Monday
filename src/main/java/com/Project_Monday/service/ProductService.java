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

    public void addProduct(Product product){
        repo.save(product);
    }

    public void deleteProduct(int prodId){
        repo.deleteById(prodId);
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int productId){
        return repo.findById(productId).orElse(new Product());
    }

}
