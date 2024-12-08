package com.Project_Monday.controller;

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
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        if (customerService.checkCustomer(username, password)) {
            if (customerService.checkDomain(username)){
                return "seller";
            }
            else {
                return "buyer";
            }
        } else {
            return "login";
        }
    }

    @PostMapping("/signup")
    public String addCustomer(@RequestParam String name,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String role) {
        if (customerService.existingCustomer(username)) {
            return "signup";
        } else {
            customerService.addCustomer(name, username, password, role);
            return "login";
        }
    }
}
