package com.marketplace.shoppingcartservice.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;


/**
 * Сущность, соответствующая одному конкретному предмету в корзине.
 * id - уникальный идентификатор предмета корзины
 * itemId - uuid предмета, сущность Catalog, которая будет приходить извне
 * profile - профиль покупателя
 * count - количество предмета в корзине
 * price - цена предмета
 * isDiscounted - применена ли скидка
 * discountPrice - размер скидки
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_id")
    private UUID itemId;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;


    @Min(value = 0)
    @Column(name = "count")
    private Integer count;


    @Min(value = 0)
    @Column(name = "price")
    private Long price;

    @Column(name = "is_discounted")
    private Boolean isDiscounted;


    @Min(value = 0)
    @Column(name = "discount_price")
    private Long discountPrice;



}

