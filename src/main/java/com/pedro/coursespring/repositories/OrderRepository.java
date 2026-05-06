package com.pedro.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.coursespring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    
}