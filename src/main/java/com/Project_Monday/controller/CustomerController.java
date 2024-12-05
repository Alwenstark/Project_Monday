package com.Project_Monday.controller;

import com.Project_Monday.model.Customer;
import com.Project_Monday.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/home")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (customerService.checkCustomer(username, password)) {
            return "home";
        } else {
            return "login";
        }
    }

    @PostMapping("/signup")
    public String addCustomer(@RequestParam String name, @RequestParam String username, @RequestParam String password) {
        if (customerService.existingCustomer(username)) {
            return "signup";
        } else {
            Customer customer = new Customer(name, username, password);
            customerService.addCustomer(customer);
            return "login";
        }
    }

}
