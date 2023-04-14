package com.rduttaassesment.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rduttaassesment.productservice.dto.ProductRequest;
import com.rduttaassesment.productservice.dto.ProductResponse;
import com.rduttaassesment.productservice.service.ProductService;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final ProductService pService;
    
    @Autowired
    public ProductController(ProductService pService) {
        this.pService = pService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest prodcutReq){
        pService.createProduct(prodcutReq);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return pService.getAllProducts();
    }
}
