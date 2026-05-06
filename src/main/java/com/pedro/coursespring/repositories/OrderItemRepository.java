package com.pedro.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.coursespring.entities.OrderItem;
import com.pedro.coursespring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}