package com.pedro.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.coursespring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}