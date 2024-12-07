package com.Project_Monday.service;

import com.Project_Monday.model.Kart;
import com.Project_Monday.model.Product;
import com.Project_Monday.repository.KartRepo;
import com.Project_Monday.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KartService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private KartRepo kartRepo;

    public void addKart(Long productId){
    Product product = productRepo.findByProductId(productId);
    Kart kart = new Kart();
    kart.addtoKart(product);
    kartRepo.save(kart);
    }
}
