package com.rduttaassesment.inventaryservice.serviceimpl;

import com.rduttaassesment.inventaryservice.dto.InventaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rduttaassesment.inventaryservice.repository.InventaryRepository;
import com.rduttaassesment.inventaryservice.service.InventaryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventaryServiceImpl implements InventaryService{

    private final InventaryRepository inventaryRepository;

    @Autowired
    public InventaryServiceImpl(InventaryRepository inventaryRepository) {
        this.inventaryRepository = inventaryRepository;
    }



    @Transactional(readOnly = true)
    @Override
    public List<InventaryResponse> isInStock(List<String> skuCode) {
        return inventaryRepository.findBySkuCodeIn(skuCode).stream().map(inventary ->
            InventaryResponse.builder().skuCode(inventary.getSkuCode())
                    .isInStock(inventary.getQuantity() > 0)
                    .build()).collect(Collectors.toList());
    }
    
}
