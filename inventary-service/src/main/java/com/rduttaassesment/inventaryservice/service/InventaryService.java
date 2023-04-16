package com.rduttaassesment.inventaryservice.service;

import com.rduttaassesment.inventaryservice.dto.InventaryResponse;

import java.util.List;

public interface InventaryService {
    List<InventaryResponse> isInStock(List<String> skuCode) throws InterruptedException;
}
