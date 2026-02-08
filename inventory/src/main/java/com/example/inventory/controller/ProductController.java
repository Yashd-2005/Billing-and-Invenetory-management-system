package com.example.inventory.controller;

import com.example.inventory.dto.StockUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.inventory.service.ProductService;
import com.example.inventory.model.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;



    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.addProduct(p);
    }


    @GetMapping
    public List<Product> all() {
        return service.getAll();
    }
    @PutMapping("/{id}/add-stock")
    public Product addStock(@PathVariable Long id,
                            @RequestBody StockUpdateRequest request) {
        return service.addStock(id, request.getQuantity());
    }

}
