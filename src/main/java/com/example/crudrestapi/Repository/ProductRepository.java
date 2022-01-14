package com.example.crudrestapi.Repository;

import com.example.crudrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
