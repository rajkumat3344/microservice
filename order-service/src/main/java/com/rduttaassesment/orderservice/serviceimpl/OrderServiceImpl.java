package com.rduttaassesment.orderservice.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.rduttaassesment.orderservice.dto.InventaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rduttaassesment.orderservice.dto.OrderLineItemsDTO;
import com.rduttaassesment.orderservice.dto.OrderRequest;
import com.rduttaassesment.orderservice.model.Order;
import com.rduttaassesment.orderservice.model.OrderLineItems;
import com.rduttaassesment.orderservice.repository.OrderRepository;
import com.rduttaassesment.orderservice.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRep;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRep, WebClient.Builder webClientBuilder) {
        this.orderRep = orderRep;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
       Order order = new Order();
       order.setOrderNumber(UUID.randomUUID().toString());

       List<OrderLineItems> orderLineItems = orderRequest.getOrderLineDTOList()
                   .stream().map(orderLineItemsDTO -> mapToDTO(orderLineItemsDTO)).collect(Collectors.toList());

        order.setOrderLineItems(orderLineItems);

        //Collect all the skuCode from the Order object
        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).collect(Collectors.toList());

        //Call inventary service before proceessing the Order if Item/Product present then Order it else Throw not in Stock.
       InventaryResponse[] inventaryResp= webClientBuilder.build().get().uri("http://inventary-service/api/inventary",
                uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build()).retrieve().bodyToMono(InventaryResponse[].class).block();

        //If one of the product not found this return false or if statement got false then it will go to else part
        boolean allProductsInStock = Arrays.stream(inventaryResp).allMatch(InventaryResponse::isInStock);


        if(allProductsInStock){
            orderRep.save(order);
        }else{
            throw new IllegalArgumentException("Product is not in stock, please try again later.");
        }

        log.info("Order {} is saved.", order.getId());

    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());

        return orderLineItems;
    }
    
}
