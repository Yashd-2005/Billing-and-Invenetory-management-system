package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventory.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {}