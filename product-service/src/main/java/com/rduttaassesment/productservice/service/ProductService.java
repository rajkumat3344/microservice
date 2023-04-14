package com.rduttaassesment.productservice.service;

import java.util.List;

import com.rduttaassesment.productservice.dto.ProductRequest;
import com.rduttaassesment.productservice.dto.ProductResponse;

public interface ProductService {
    void createProduct(ProductRequest productReq);
    List<ProductResponse> getAllProducts();
}
