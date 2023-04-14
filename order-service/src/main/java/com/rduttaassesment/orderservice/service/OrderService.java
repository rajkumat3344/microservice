package com.rduttaassesment.orderservice.service;

import com.rduttaassesment.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
