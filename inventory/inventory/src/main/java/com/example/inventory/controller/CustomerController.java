package com.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.inventory.service.CustomerService;
import com.example.inventory.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public Customer add(@RequestBody Customer c) {
        return service.addCustomer(c);
    }

    @GetMapping
    public List<Customer> all() {
        return service.getAllCustomers();
    }
}