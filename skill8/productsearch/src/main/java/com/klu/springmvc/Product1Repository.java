package com.klu.springmvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product1Repository extends JpaRepository<Product1, Integer> {
    // No need to add anything for basic CRUD
}