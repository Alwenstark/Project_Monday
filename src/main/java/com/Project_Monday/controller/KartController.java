package com.Project_Monday.controller;

import com.Project_Monday.model.Product;
import com.Project_Monday.service.KartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KartController {

    @Autowired
    private KartService kartService;


    @PostMapping("/addkart")
    public String addKart(@RequestParam Long productId){
        kartService.addKart(productId);
        return "seller";

    }
}
