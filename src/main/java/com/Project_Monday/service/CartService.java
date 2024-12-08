package com.Project_Monday.service;

import com.Project_Monday.model.Cart;
import com.Project_Monday.model.Customer;
import com.Project_Monday.model.Product;
import com.Project_Monday.repository.CartRepo;
import com.Project_Monday.repository.CustomerRepo;
import com.Project_Monday.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepo cartRepo;

    public void addtocart(Long productId,Long customerId){
        Cart cart = getCartByCustomerId(customerId);
        Product product = productService.getProductById(productId);
        cart.getProducts().add(product);
        cartRepo.save(cart);
    }

    public Cart getCartByCustomerId(Long customerId){
        return cartRepo.findById(customerId).orElse(null);
    }



}
