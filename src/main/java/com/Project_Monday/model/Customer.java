package com.Project_Monday.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String username;

    public Customer() {
    }

    public Customer(String name,String username,String password){
        this.name=name;
        this.username=username;
        this.password=password;
    }
}
