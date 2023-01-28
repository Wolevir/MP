package com.marketplace.shoppingcartservice.controller;

import com.marketplace.shoppingcartservice.entity.CartItem;
import com.marketplace.shoppingcartservice.entity.Profile;
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

    private final CartItemService cartItemService;

    @PostMapping("/order/{id}")
    public ResponseEntity<List<CartItem>> orderList(@PathVariable UUID id) {
        cartItemService.getOrderList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
