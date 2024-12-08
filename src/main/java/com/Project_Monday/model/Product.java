package com.Project_Monday.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String size;
    private double price;
    private String category;
    private String description;
    private String color;
    private String image_url;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Cart> cart;

    public Product() {
    }

    public Product(Long productId, String name, String size, double price, String category, String description, String color, String image_url) {
        this.productId = productId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
        this.description = description;
        this.color = color;
        this.image_url = image_url;
    }
}
