package com.marketplace.shoppingcartservice.repository;

import com.marketplace.shoppingcartservice.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT c from CartItem c where c.itemId= :id")
    List<CartItem> getListProducts(UUID id);

}
