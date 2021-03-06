package com.emma.bookz.repository;


import com.emma.bookz.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//the repository comments
public interface ProductRepository extends JpaRepository<Product, Long> {
}
