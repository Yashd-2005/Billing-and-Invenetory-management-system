package com.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.inventory.service.BillService;
import com.example.inventory.model.Bill;
import com.example.inventory.model.BillItem;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/{customerId}")
    public Bill createBill(@PathVariable Long customerId,
                           @RequestBody List<BillItem> items) {
        return billService.createBill(customerId, items);
    }
    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id) {
        return billService.getBill(id);
    }

}