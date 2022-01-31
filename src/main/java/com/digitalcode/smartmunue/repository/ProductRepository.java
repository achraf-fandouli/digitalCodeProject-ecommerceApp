package com.digitalcode.smartmunue.repository;

import com.digitalcode.smartmunue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
