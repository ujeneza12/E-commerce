package com.rca.ac.rw.Ecommerce.model.dao;

import com.rca.ac.rw.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
