package com.Project_Monday.service;

import com.Project_Monday.model.Cart;
import com.Project_Monday.model.Customer;
import com.Project_Monday.model.CustomerType;
import com.Project_Monday.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void addCustomer(String name,
                            String username,
                            String password,
                            String role)
    {
        CustomerType customerType = CustomerType.valueOf(role);
        Customer customer = new Customer(name, username, password,customerType);
        Cart cart = new Cart();
        customer.setCart(cart);
        cart.setCustomer(customer);
        customerRepo.save(customer);
    }

    public boolean checkCustomer(String username, String password) {
        Customer customer = customerRepo.findByUsername(username);
        return customer != null && customer.getPassword().equals(password);
    }

    public boolean checkDomain(String username){
        Customer customer = customerRepo.findByUsername(username);
        CustomerType customerType = customer.getCustomerType();
        return customerType!=CustomerType.BUYER;
    }

    public boolean existingCustomer(String username) {
        return customerRepo.findByUsername(username) != null;
    }
}
