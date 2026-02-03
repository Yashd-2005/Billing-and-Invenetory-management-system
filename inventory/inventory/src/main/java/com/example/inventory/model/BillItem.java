package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Bill bill;

    private int quantity;
    private double price;
}