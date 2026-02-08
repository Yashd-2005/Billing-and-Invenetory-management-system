package com.example.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.inventory.repository.*;
import com.example.inventory.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepo;
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;

    public Bill createBill(Long customerId, List<BillItem> itemsRequest) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Bill bill = new Bill();
        bill.setCustomer(customer);

        double total = 0;
        List<BillItem> savedItems = new ArrayList<>();

        for (BillItem item : itemsRequest) {

            Product product = productRepo.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for " + product.getName());
            }

            // Reduce stock
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepo.save(product);

            BillItem billItem = new BillItem();
            billItem.setBill(bill);
            billItem.setProduct(product);
            billItem.setQuantity(item.getQuantity());
            billItem.setPrice(product.getPrice());

            total += product.getPrice() * item.getQuantity();
            savedItems.add(billItem);
        }

        bill.setItems(savedItems);
        bill.setTotalAmount(total);

        return billRepo.save(bill);
    }
}