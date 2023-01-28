package com.marketplace.shoppingcartservice.services;

import com.marketplace.shoppingcartservice.entity.CartItem;
import com.marketplace.shoppingcartservice.entity.Profile;
import com.marketplace.shoppingcartservice.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartItemImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate kafkaTemplate;

    @Transactional
    @Override
    public List<CartItem> getListProducts(UUID id) {
        return cartItemRepository.getListProducts(id);
    }

    @Override
    public void getOrderList(UUID id) {
        kafkaTemplate.send(topicName, getListProducts(id).toString());
    }


}
