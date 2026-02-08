package com.example.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.inventory.repository.CustomerRepository;
import com.example.inventory.model.Customer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;

    public Customer addCustomer(Customer c) {
        return repo.save(c);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
}