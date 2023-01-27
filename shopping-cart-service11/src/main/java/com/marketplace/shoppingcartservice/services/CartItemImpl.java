package com.marketplace.shoppingcartservice.services;

import com.marketplace.shoppingcartservice.entity.CartItem;
import com.marketplace.shoppingcartservice.entity.Profile;
import com.marketplace.shoppingcartservice.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CartItemImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getListProducts(UUID id) {
        return cartItemRepository.getListProducts(id);
    }


}
