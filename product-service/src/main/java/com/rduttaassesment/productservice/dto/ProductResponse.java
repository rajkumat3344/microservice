package com.rduttaassesment.productservice.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
