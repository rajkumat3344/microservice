package com.rduttaassesment.productservice.model;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Product {
    @Id
    @Builder.Default
    private Long id = ThreadLocalRandom.current().nextLong(1000, 10000);
    private String name;
    private String description;
    private BigDecimal price;
}
