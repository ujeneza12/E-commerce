package com.rca.ac.rw.Ecommerce.model.dao;

import com.rca.ac.rw.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}

//public interface ProductDAO extends JpaRepository<Product, Integer> {
//}
