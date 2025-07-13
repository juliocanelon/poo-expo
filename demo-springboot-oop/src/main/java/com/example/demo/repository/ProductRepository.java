package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Product CRUD operations.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
