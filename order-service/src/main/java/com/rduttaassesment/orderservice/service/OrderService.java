package com.rduttaassesment.orderservice.service;

import com.rduttaassesment.orderservice.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
