package com.Project_Monday.controller;


import com.Project_Monday.model.Cart;
import com.Project_Monday.model.Product;
import com.Project_Monday.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{pid}/{cid}")
    public String addtoCart(@PathVariable("pid") Long productId,
                            @PathVariable("cid") Long customerId) {
        cartService.addtocart(productId,customerId);
        return "added";
    }

    @GetMapping("/get/{cid}")
    public List<Product> getcartlist(@PathVariable("cid") Long customerId){
        Cart cart=cartService.getCartByCustomerId(customerId);
        return cart!=null ? cart.getProducts():null;
    }
}
