package com.Project_Monday.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String password;
    private String username;

    @Enumerated(EnumType.STRING) 
    private CustomerType customerType;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    public Customer(String name,String username,String password,CustomerType customerType){
        this.name=name;
        this.username=username;
        this.password=password;
        this.customerType=customerType;
    }
}
