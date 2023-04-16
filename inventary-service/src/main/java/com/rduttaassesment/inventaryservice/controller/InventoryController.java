package com.rduttaassesment.inventaryservice.controller;

import com.rduttaassesment.inventaryservice.dto.InventaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.rduttaassesment.inventaryservice.service.InventaryService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/inventary")
public class InventoryController {


    private final InventaryService inventaryService;

    @Autowired
    public InventoryController(InventaryService inventaryService) {
        this.inventaryService = inventaryService;
    }

    
    

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventaryResponse> isInStock(@RequestParam List<String> skuCode) throws Exception {
        return inventaryService.isInStock(skuCode);
    }
}
