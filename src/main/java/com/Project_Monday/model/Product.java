package com.Project_Monday.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
    private String image;

    public Product() {
    }

    public Product(Long productId, String name, String size, double price, String category, String description, String color, String image) {
        this.productId = productId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
        this.description = description;
        this.color = color;
        this.image = image;
    }
}
