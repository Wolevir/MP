package com.marketplace.shoppingcartservice.services;

import com.marketplace.shoppingcartservice.entity.CartItem;
import com.marketplace.shoppingcartservice.entity.Profile;

import java.util.List;
import java.util.UUID;


public interface CartItemService {
    List<CartItem> getListProducts(UUID id);

    void getOrderList(UUID id);
}
