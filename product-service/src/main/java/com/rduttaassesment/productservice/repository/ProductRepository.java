package com.rduttaassesment.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rduttaassesment.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    
}
