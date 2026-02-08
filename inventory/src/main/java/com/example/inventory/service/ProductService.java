package com.example.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;



    public Product addProduct(Product p) {
        return repo.save(p);
    }
    public Product addStock(Long productId, int quantity) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setQuantity(product.getQuantity() + quantity);
        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }
}
