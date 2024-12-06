package com.Project_Monday.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String username;

    @Enumerated(EnumType.STRING) 
    private CustomerType customerType;

    public Customer(String name,String username,String password,CustomerType customerType){
        this.name=name;
        this.username=username;
        this.password=password;
        this.customerType=customerType;
    }
}
