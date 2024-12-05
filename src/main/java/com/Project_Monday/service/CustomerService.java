package com.Project_Monday.service;

import com.Project_Monday.model.Customer;
import com.Project_Monday.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public boolean checkCustomer(String username, String password) {
        Customer customer = customerRepo.findByUsername(username);
        return customer != null && customer.getPassword().equals(password);
    }

    public boolean existingCustomer(String username) {
        return customerRepo.findByUsername(username) != null;
    }
}
