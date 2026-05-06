package com.pedro.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.coursespring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    
}