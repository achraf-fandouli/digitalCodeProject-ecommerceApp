package com.digitalcode.smartmunue.repository;

import com.digitalcode.smartmunue.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
