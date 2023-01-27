package com.marketplace.shoppingcartservice.controller;

import com.marketplace.shoppingcartservice.entity.CartItem;
import com.marketplace.shoppingcartservice.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class RestControllerCart {

    private final KafkaTemplate kafkaTemplate;
    private final CartItemService cartItemService;

    @PostMapping("/order/{id}")
    public ResponseEntity<List<CartItem>> orderList( @PathVariable UUID id) {
        kafkaTemplate.send("orders_cart", cartItemService.getListProducts(id).toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
