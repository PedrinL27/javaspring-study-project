package com.pedro.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.coursespring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
}