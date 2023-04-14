package com.rduttaassesment.productservice.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rduttaassesment.productservice.dto.ProductRequest;
import com.rduttaassesment.productservice.dto.ProductResponse;
import com.rduttaassesment.productservice.model.Product;
import com.rduttaassesment.productservice.repository.ProductRepository;
import com.rduttaassesment.productservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

  
    private final ProductRepository productRep;

    @Autowired
    public ProductServiceImpl(ProductRepository productRep) {
        this.productRep = productRep;
    }



    @Override
    public void createProduct(ProductRequest productReq) {
        Product product = Product.builder()
                .name(productReq.getName())
                .description(productReq.getDescription())
                .price(productReq.getPrice())
                .build();

                productRep.save(product);
                log.info("Product {} is  saved.", product.getId());
    }



    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products =  productRep.findAll();
       return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
               .id(product.getId())
               .name(product.getName())
               .description(product.getDescription())
               .price(product.getPrice())
               .build();
    }
    
}
