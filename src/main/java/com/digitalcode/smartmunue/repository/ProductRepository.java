package com.digitalcode.smartmunue.repository;

import com.digitalcode.smartmunue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllProductByCategory_Id(int id);
}
