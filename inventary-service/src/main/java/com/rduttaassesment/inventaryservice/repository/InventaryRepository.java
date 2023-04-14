package com.rduttaassesment.inventaryservice.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rduttaassesment.inventaryservice.model.Inventary;

@Repository
public interface InventaryRepository extends JpaRepository<Inventary, Long>{
    List<Inventary> findBySkuCodeIn(List<String> skuCode);
}
